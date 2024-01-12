<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Etudiant;
use App\Entity\EtudiantFormation;
use App\Entity\Formation;
use App\Form\CoursType;
use App\Form\FormationType;
use App\Form\PromotionType;
use App\Repository\EtudiantRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Yamilovs\Bundle\SmsBundle\Service\ProviderManager;
use Yamilovs\Bundle\SmsBundle\Sms\Sms;
/**
 * @Route("/admin/etudiantFormations")
 */
class EtudiantFormationController extends AbstractController
{

    /**
     * @Route("/{id}", name="admin_etudiant_formation")
     */
    public function listeofStudent($id): Response
    {
        $formation =$this->getDoctrine()->getRepository(Formation::class)->find($id);
        return $this->render('admin/etudiantformation/index.html.twig', [
            'controller_name' => 'EtudiantFormationController',
            'liste'=> $this->getDoctrine()->getRepository(EtudiantFormation::class)->findBy(["formation"=>$id]),
            'formation'=>$formation
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_etudiant_formation_form")
     */
    public function newEtudiantFormation(Request $request,$id,ProviderManager $providerManager): Response
    {
        $formation =$this->getDoctrine()->getRepository(Formation::class)->find($id);
        $defaultData = ['message' => 'Type your message here'];
        $form = $this->createFormBuilder($defaultData)
            ->add('student', EntityType::class, [
                'class' => Etudiant::class,
                'query_builder' => function (EtudiantRepository $etudiantRepository) {
                    return $etudiantRepository->findEtudiants();
                },
                'required' => true,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition'
                ],
                'placeholder' => 'Choose Consultant',
            ])
            ->getForm();

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $val=$this->getDoctrine()->getRepository(EtudiantFormation::class)->findOneBy(["formation"=>$id,"etudiant"=>$form['student']->getData()]);
            if(empty($val)){
                $etudiantFormation=new EtudiantFormation();
                $etudiantFormation->setEtudiant($form['student']->getData());
                $etudiantFormation->setFormation($formation);
                $entityManager = $this->getDoctrine()->getManager();
                $entityManager->persist($etudiantFormation);
                $this->getDoctrine()->getManager()->flush();
                $sms = new Sms('+21626104108', 'Votre inscription a etait effectué avec succés');
                $provider = $providerManager->getProvider('message_bird_provider_doc');
                $provider->send($sms);
                $this->addFlash('success', 'Etudiant ajouté avec succées');
                return $this->redirectToRoute('admin_etudiant_formation',['id'=>$etudiantFormation->getFormation()->getId()]);

            }
            $this->addFlash('danger', 'Etudiant déja inscrit');

        }


            return $this->render('admin/etudiantformation/form.html.twig', [
            'controller_name' => 'CoursController',
            'form' => $form->createView(),
                'title'=>"Ajouter un nouveau etudiant  à ".$formation->getTitre(),
                'formation'=>$formation
        ]);
    }



    /**
     * @Route("/delete/{id}", name="admin_etudiant_formation_delete")
     */
    public function deleteEtudiantFormation($id): Response
    {
        $etudiantFormation =$this->getDoctrine()->getRepository(EtudiantFormation::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($etudiantFormation);
        $em->flush();
        $this->addFlash('danger', 'Inscription supprimé avec succées');
        return $this->redirectToRoute('admin_etudiant_formation',['id'=>$etudiantFormation->getFormation()->getId()]);

    }
}
