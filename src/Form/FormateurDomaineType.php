<?php


namespace App\Form;


use App\Entity\Domaine;
use App\Entity\Enseignant;
use App\Entity\Formateur;
use App\Repository\DomaineRepository;
use App\Repository\EnseignantRepository;
use App\Repository\FormateurRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\File;

class FormateurDomaineType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('domaines', EntityType::class, [
                'class' => Domaine::class,
                'query_builder' => function (DomaineRepository $domaineRepository) {
                    return $domaineRepository->findDomaines();
                },
                'multiple'=>true,
                'required' => true,
                'mapped'=>false,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition'
                ],
                'placeholder' => 'Choose domaine',
            ])




        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
        ]);
    }
}
