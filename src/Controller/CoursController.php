<?php

namespace App\Controller;


use App\Entity\Cours;
use App\Entity\Formation;
use App\Entity\Utilisateur;
use App\Form\CoursType;
use App\Form\FormationType;
use App\Form\PromotionType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;

/**
 * @Route("/admin/cours")
 */
class CoursController extends AbstractController
{

    /**
     * @Route("/", name="admin_cours")
     */
    public function cours(): Response
    {
        return $this->render('admin/cours/index.html.twig', [
            'controller_name' => 'CoursController',
            'cours'=> $this->getDoctrine()->getRepository(Cours::class)->findAll(),
        ]);

    }

    /**
     * @Route("/form", name="admin_cours_form")
     */
    public function newCours(Request $request): Response
    {
        $cours =new Cours();
        $form = $this->createForm(CoursType::class, $cours);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['image']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/cours';
                $newFilename = 'cours-image-'.uniqid().".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $cours->setImage($newFilename);
            }
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/cours';
                $newFilename = 'cours-file-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $cours->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($cours);
            $https['ssl']['verify_peer'] = FALSE;
            $https['ssl']['verify_peer_name'] = FALSE;
            $transporter = (new \Swift_SmtpTransport('smtp.googlemail.com', 465, 'ssl'))
                ->setAuthMode('login')
                ->setUsername('course.esprit@gmail.com')
                ->setPassword('13001074');
            $transporter->setStreamOptions($https);
            $mailer = new \Swift_Mailer($transporter);
            foreach ($this->getDoctrine()->getRepository(Utilisateur::class)->findAll() as $client) {
                    $message = (new \Swift_Message('new course'))
                        ->setFrom('course.esprit@gmail.com')
                        ->setTo($client->getEmail())
                        ->setBody(
                            $this->renderView(
                                'mail/newcourse.html.twig',
                                ['course' => $cours]
                            ),
                            'text/html'
                        );
                    $mailer->send($message);
            }
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Cours ajouté avec succées');
            return $this->redirectToRoute('admin_cours');
        }

            return $this->render('admin/cours/form.html.twig', [
            'controller_name' => 'CoursController',
            'form' => $form->createView(),
                'title'=>"Ajouter un nouveau cours",
                'cours'=>$cours
        ]);
    }

    /**
     * @Route("/form/{id}", name="admin_cours_edit")
     */
    public function editCours(Request $request , $id): Response
    {
        $cours =$this->getDoctrine()->getRepository(Cours::class)->find($id);
        $form = $this->createForm(CoursType::class, $cours);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            /** @var UploadedFile $uploadedFile */
            $uploadedFile = $form['image']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/cours';
                $newFilename = 'cours-image-'.uniqid().".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $cours->setImage($newFilename);
            }
            $uploadedFile = $form['file']->getData();
            if ($uploadedFile) {
                $destination = $this->getParameter('kernel.project_dir') . '/public/cours';
                $newFilename = 'cours-file-'.uniqid() .".". $uploadedFile->guessExtension();
                $uploadedFile->move(
                    $destination,
                    $newFilename
                );
                $cours->setFile($newFilename);
            }
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($cours);
            $this->getDoctrine()->getManager()->flush();
            $this->addFlash('success', 'Cours modifié avec succées');
            return $this->redirectToRoute('admin_cours');
        }

        return $this->render('admin/cours/form.html.twig', [
            'controller_name' => 'CoursController',
            'form' => $form->createView(),
            'title'=>"Modifier un cours",
            'cours'=>$cours
        ]);
    }

    /**
     * @Route("/delete/{id}", name="admin_cours_delete")
     */
    public function deletecours($id): Response
    {
        $cours =$this->getDoctrine()->getRepository(Cours::class)->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($cours);
        $em->flush();
        $this->addFlash('danger', 'Cours supprimé avec succées');
        return $this->redirectToRoute('admin_cours');

    }
}
