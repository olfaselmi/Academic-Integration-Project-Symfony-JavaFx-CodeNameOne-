<?php

namespace App\Controller;


use App\Entity\Formation;
use App\Form\FormationType;
use App\Form\PromotionType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

/**
 * @Route("/admin/formations")
 */
class FormationController extends AbstractController
{

    /**
     * @Route("/", name="admin_formations")
     */
    public function formations(): Response
    {
        return $this->render('admin/formation/index.html.twig', [
            'controller_name' => 'FormationController',
            'formations'=> $this->getDoctrine()->getRepository(Formation::class)->findAll(),
        ]);

    }

    /**
     * @Route("/form", name="admin_formation_form")
     */
    public function newFormation(Request $request): Response
    {
        $formation =new Formation();
        $form = $this->createForm(FormationType::class, $formation);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['image']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/formation';
                $newFilename = 'formation-image-'.uniqid().".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $formation->setImage($newFilename);
            }
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/formation';
                $newFilename = 'formation-file-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $formation->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($formation);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Formation ajoutée avec succées');
            return $this->redirectToRoute('admin_formations');
        }

            return $this->render('admin/formation/form.html.twig', [
            'controller_name' => 'FormationController',
            'form' => $form->createView(),
                'title'=>"Ajouter une nouvelle formation",
                'formation'=>$formation
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_formation_edit")
     */
    public function editFormation(Request $request , $id): Response
    {
        $formation =$this->getDoctrine()->getRepository(Formation::class)->find($id);
        $form = $this->createForm(FormationType::class, $formation);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['image']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/formation';
                $newFilename = 'formation-image-'.uniqid().".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $formation->setImage($newFilename);
            }
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/formation';
                $newFilename = 'formation-file-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $formation->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($formation);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Formation modifiée avec succées');
            return $this->redirectToRoute('admin_formations');
        }

        return $this->render('admin/formation/form.html.twig', [
            'controller_name' => 'FormationController',
            'form' => $form->createView(),
            'title'=>"Modifier une formation",
            'formation'=>$formation
        ]);
    }

    /**
     * @Route("/delete/{id}", name="admin_formation_delete")
     */
    public function deleteFormation($id): Response
    {
        $formation =$this->getDoctrine()->getRepository(Formation::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($formation);
        $em->flush();
        $this->addFlash('danger', 'Formation supprimée avec succées');
        return $this->redirectToRoute('admin_formations');

    }
}
