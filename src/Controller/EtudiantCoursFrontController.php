<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Etudiant;
use App\Entity\EtudiantCours;
use App\Entity\Formation;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


/**
 * @Route("/etudiantCours")
 */
class EtudiantCoursFrontController extends AbstractController
{



    /**
     * @Route("/", name="etudiant_courses_show_student")
     */
    public function showCoursByStudent(): Response
    {
        $id=1;
        //user connecté
        return $this->render('front/cours/mescours.html.twig', [
            'controller_name' => 'CoursFrontController',
            'liste'=>$this->getDoctrine()->getRepository(EtudiantCours::class)->findBy(["etudiant"=>$id]),

        ]);

    }


}
