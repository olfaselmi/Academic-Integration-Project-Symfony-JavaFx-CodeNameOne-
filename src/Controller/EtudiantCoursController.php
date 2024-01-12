<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Etudiant;
use App\Entity\EtudiantCours;
use App\Form\CoursType;
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
 * @Route("/admin/etudiantCours")
 */
class EtudiantCoursController extends AbstractController
{

    /**
     * @Route("/{id}", name="admin_etudiant_cours")
     */
    public function listeofStudent($id): Response
    {
        $cours =$this->getDoctrine()->getRepository(Cours::class)->find($id);
        return $this->render('admin/etudiantcours/index.html.twig', [
            'controller_name' => 'EtudiantCoursController',
            'liste'=> $this->getDoctrine()->getRepository(EtudiantCours::class)->findBy(["cours"=>$id]),
            'cours'=>$cours
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_etudiant_cours_form")
     */
    public function newetudiantCours(Request $request,$id,ProviderManager $providerManager): Response
    {
        $cours =$this->getDoctrine()->getRepository(Cours::class)->find($id);
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
                'placeholder' => 'Choose Student',
            ])
            ->getForm();

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $val=$this->getDoctrine()->getRepository(EtudiantCours::class)->findOneBy(["cours"=>$id,"etudiant"=>$form['student']->getData()]);
            if(empty($val)){
                $etudiantCours=new EtudiantCours();
                $etudiantCours->setEtudiant($form['student']->getData());
                $etudiantCours->setCours($cours);
                $entityManager = $this->getDoctrine()->getManager();
                $entityManager->persist($etudiantCours);
                $this->getDoctrine()->getManager()->flush();
                 $sms = new Sms('+21626104108', 'Votre inscription a etait effectué avec succés');
                $provider = $providerManager->getProvider('message_bird_provider_doc');
                $provider->send($sms);
                $this->addFlash('success', 'Etudiant ajouté avec succées');
                return $this->redirectToRoute('admin_etudiant_cours',['id'=>$id]);

            }
            $this->addFlash('danger', 'Etudiant déja inscrit');

        }


            return $this->render('admin/etudiantcours/form.html.twig', [
            'controller_name' => 'CoursController',
            'form' => $form->createView(),
                'title'=>"Ajouter un nouveau etudiant  à ".$cours->getTitre(),
                '$cours'=>$cours
        ]);
    }



    /**
     * @Route("/delete/{id}", name="admin_etudiant_cours_delete")
     */
    public function deleteetudiantCours($id): Response
    {
        $etudiantCours =$this->getDoctrine()->getRepository(EtudiantCours::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($etudiantCours);
        $em->flush();
        $this->addFlash('danger', 'Inscription supprimé avec succées');
        return $this->redirectToRoute('admin_etudiant_cours',['id'=>$etudiantCours->getCours()->getId()]);

    }
}
