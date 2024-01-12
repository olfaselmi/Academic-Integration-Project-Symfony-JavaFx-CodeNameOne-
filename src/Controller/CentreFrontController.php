<?php

namespace App\Controller;


use App\Entity\Centre;
use App\Entity\Cours;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


/**
 * @Route("/center")
 */
class CentreFrontController extends AbstractController
{

    /**
     * @Route("/", name="centres")
     */
    public function cours(Request $request): Response
    {
        $centres=$this->getDoctrine()->getRepository(Centre::class)->findAll();
        if ($request->query->get('filter')) {
            $centres=$this->getDoctrine()->getRepository(Centre::class)->findSearch($request->query->get('filter'));
        }
        return $this->render('front/centre/index.html.twig', [
            'controller_name' => 'CoursFrontController',
            'centres'=> $centres,
        ]);

    }



}
