<?php

namespace App\Controller;


use App\Entity\Centre;
use App\Entity\Cours;
use App\Entity\Domaine;
use App\Form\CentreType;
use App\Form\CoursType;
use App\Form\DomaineType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

/**
 * @Route("/admin/domaines")
 */
class DomaineController extends AbstractController
{

    /**
     * @Route("/", name="admin_domaine")
     */
    public function index(): Response
    {
        return $this->render('admin/domaine/index.html.twig', [
            'controller_name' => 'DomaineController',
            'domaines'=> $this->getDoctrine()->getRepository(Domaine::class)->findAll(),
        ]);

    }

    /**
     * @Route("/form", name="admin_domaine_form")
     */
    public function newDomaine(Request $request): Response
    {
        $domaine =new Domaine();
        $form = $this->createForm(DomaineType::class, $domaine);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {

            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($domaine);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Domaine ajouté avec succées');
            return $this->redirectToRoute('admin_domaine');
        }

            return $this->render('admin/domaine/form.html.twig', [
            'controller_name' => 'DomaineController',
            'form' => $form->createView(),
                'title'=>"Ajouter un nouveau domaine",
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_domaine_edit")
     */
    public function editDomaine(Request $request , $id): Response
    {
        $domaine =$this->getDoctrine()->getRepository(Domaine::class)->find($id);
        $form = $this->createForm(DomaineType::class, $domaine);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {

            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($domaine);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Domaine modifié avec succées');
            return $this->redirectToRoute('admin_domaine');
        }

        return $this->render('admin/domaine/form.html.twig', [
            'controller_name' => 'DomaineController',
            'form' => $form->createView(),
            'title'=>"Modifier un domaine",
        ]);
    }

    /**
     * @Route("/delete/{id}", name="admin_domaine_delete")
     */
    public function deletecentre($id): Response
    {
        $domaine =$this->getDoctrine()->getRepository(Domaine::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($domaine);
        $em->flush();
        $this->addFlash('danger', 'Domaine supprimé avec succées');
        return $this->redirectToRoute('admin_domaine');

    }
}
