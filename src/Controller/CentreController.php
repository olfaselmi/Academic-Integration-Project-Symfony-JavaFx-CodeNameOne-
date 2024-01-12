<?php

namespace App\Controller;


use App\Entity\Centre;
use App\Entity\Cours;
use App\Form\CentreType;
use App\Form\CoursType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

/**
 * @Route("/admin/centres")
 */
class CentreController extends AbstractController
{

    /**
     * @Route("/", name="admin_centre")
     */
    public function cours(): Response
    {
        return $this->render('admin/centre/index.html.twig', [
            'controller_name' => 'CentreController',
            'centres'=> $this->getDoctrine()->getRepository(Centre::class)->findAll(),
        ]);

    }

    /**
     * @Route("/form", name="admin_centre_form")
     */
    public function newCentre(Request $request): Response
    {
        $centre =new Centre();
        $form = $this->createForm(CentreType::class, $centre);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/centre';
                $newFilename = 'centre-logo-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $centre->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($centre);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Centre ajouté avec succées');
            return $this->redirectToRoute('admin_centre');
        }

            return $this->render('admin/centre/form.html.twig', [
            'controller_name' => 'CentreController',
            'form' => $form->createView(),
                'title'=>"Ajouter un nouveau centre",
                'centre'=>$centre
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_centre_edit")
     */
    public function editCentre(Request $request , $id): Response
    {
        $centre =$this->getDoctrine()->getRepository(Centre::class)->find($id);
        $form = $this->createForm(CentreType::class, $centre);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/centre';
                $newFilename = 'centre-logo-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $centre->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($centre);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Centre modifié avec succées');
            return $this->redirectToRoute('admin_centre');
        }

        return $this->render('admin/centre/form.html.twig', [
            'controller_name' => 'CentreController',
            'form' => $form->createView(),
            'title'=>"Modifier un centre",
            'centre'=>$centre
        ]);
    }

    /**
     * @Route("/delete/{id}", name="admin_centre_delete")
     */
    public function deletecentre($id): Response
    {
        $centre =$this->getDoctrine()->getRepository(Centre::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($centre);
        $em->flush();
        $this->addFlash('danger', 'Centre supprimé avec succées');
        return $this->redirectToRoute('admin_centre');

    }
}
