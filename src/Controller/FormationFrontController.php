<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Form;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


/**
 * @Route("/trainings")
 */
class FormationFrontController extends AbstractController
{

    /**
     * @Route("/", name="trainings")
     */
    public function trainings(Request $request): Response
    {
        $formations=$this->getDoctrine()->getRepository(Formation::class)->findAll();
        if ($request->query->get('filter')) {
            $formations=$this->getDoctrine()->getRepository(Formation::class)->findSearch($request->query->get('filter'));
        }
        return $this->render('front/formation/index.html.twig', [
            'controller_name' => 'FormationFrontController',
            'formations'=> $formations,
        ]);

    }
    /**
     * @Route("/{id}", name="training_show")
     */
    public function showTraining($id): Response
    {
        $formation =$this->getDoctrine()->getRepository(Formation::class)->find($id);
        return $this->render('front/formation/show.html.twig', [
            'controller_name' => 'FormationFrontController',
            'formation'=> $formation
        ]);

    }



}
