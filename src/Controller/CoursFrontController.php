<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Etudiant;
use App\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


/**
 * @Route("/courses")
 */
class CoursFrontController extends AbstractController
{

    /**
     * @Route("/", name="courses")
     */
    public function cours(Request $request): Response
    {
        $cours=$this->getDoctrine()->getRepository(Cours::class)->findByDate();
        if ($request->query->get('filter')) {
            $cours=$this->getDoctrine()->getRepository(Cours::class)->findSearch($request->query->get('filter'));
        }
        return $this->render('front/cours/index.html.twig', [
            'controller_name' => 'CoursFrontController',
            'cours'=> $cours,
        ]);

    }
    /**
     * @Route("/{id}", name="courses_show")
     */
    public function showcours($id): Response
    {
        $cours =$this->getDoctrine()->getRepository(Cours::class)->find($id);
        return $this->render('front/cours/show.html.twig', [
            'controller_name' => 'CoursFrontController',
            'cours'=> $cours
        ]);

    }

    /**
     * @Route("/etudiantCours", name="courses_show_student")
     */
    public function showCoursByStudent(): Response
    {
        $id=1;
        $etudiant =$this->getDoctrine()->getRepository(Etudiant::class)->find($id);

        return $this->render('front/cours/mescours.html.twig', [
            'controller_name' => 'CoursFrontController',
            'liste'=> $etudiant->getEtudiantFormations()
        ]);

    }


}
