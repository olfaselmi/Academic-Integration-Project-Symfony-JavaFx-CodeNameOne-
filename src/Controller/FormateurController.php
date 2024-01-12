<?php

namespace App\Controller;


use App\Entity\Centre;
use App\Entity\Cours;
use App\Entity\DomaineFormateur;
use App\Entity\Etudiant;
use App\Entity\EtudiantFormation;
use App\Entity\Formateur;
use App\Entity\Formation;
use App\Form\CentreType;
use App\Form\CoursType;
use App\Form\FormateurDomaineType;
use App\Form\FormationType;
use App\Repository\EtudiantRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Form;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Yamilovs\Bundle\SmsBundle\Service\ProviderManager;

/**
 * @Route("/admin/formateurs")
 */
class FormateurController extends AbstractController
{

    /**
     * @Route("/", name="admin_formateur")
     */
    public function formateurs(): Response
    {
        return $this->render('admin/formateur/index.html.twig', [
            'controller_name' => 'FormateurController',
            'formateurs'=> $this->getDoctrine()->getRepository(Formateur::class)->findAll(),
        ]);

    }

    /**
     * @Route("/form/{id}", name="admin_formateur_domaine_form")
     */
    public function newFormateurDomaine(Request $request,$id): Response
    {
        $formateur =$this->getDoctrine()->getRepository(Formateur::class)->find($id);
        $form = $this->createForm(FormateurDomaineType::class, $formateur);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $formateurs=$this->getDoctrine()->getRepository(DomaineFormateur::class)->findBy(["formateur"=>$id]);
            $em = $this->getDoctrine()->getManager();
            foreach ($formateurs as $item){
                $em->remove($item);
                $em->flush();
            }
            foreach ($form['domaines']->getData() as $item){
                $domaineFormateur=new DomaineFormateur();
                $domaineFormateur->setDomaine($item);
                $domaineFormateur->setFormateur($formateur);
                $entityManager = $this->getDoctrine()->getManager();
                $entityManager->persist($domaineFormateur);
                $this->getDoctrine()->getManager()->flush();
            }


                $this->addFlash('success', 'Formateur modifiée avec succées');
                return $this->redirectToRoute('admin_formateur');


        }


        return $this->render('admin/formateur/changeDomaine.html.twig', [
            'controller_name' => 'FormateurController',
            'form' => $form->createView(),
            'title'=>"Gérer les domaine de ".$formateur,
            'formateur'=>$formateur
        ]);
    }


}
