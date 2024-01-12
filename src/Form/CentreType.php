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

class CentreType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Nom'
                ],
                'required' => true,

            ])
            ->add('numMaison', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Numéro Maison'
                ],
                'required' => true,

            ])
            ->add('rue', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Rue'
                ],
                'required' => true,

            ])
            ->add('ville', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Ville'
                ],
                'required' => true,

            ])
            ->add('domaine', EntityType::class, [
                'class' => Domaine::class,
                'query_builder' => function (DomaineRepository $domaineRepository) {
                    return $domaineRepository->findDomaines();
                },
                'required' => true,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition',

                ],
                'placeholder' => 'Select Domaine'
            ])
            ->add('file', FileType::class, [
                'attr' => [
                    'class' => 'form-control',
                ],
                'mapped' => false,
                'required' => true,
                'constraints' => [
                    new File([
                        'maxSize' => '5M',
                        'mimeTypes' => [
                            'image/png',
                            'image/jpeg',
                        ],
                        'mimeTypesMessage' => 'Please upload a valid JPEG or PNG image',
                        'maxSizeMessage' => 'The file is too large. Allowed maximum size is 5 MiB.',
                        'uploadIniSizeErrorMessage' => 'The file is too large. Allowed maximum size is 5 MiB.',
                        'uploadFormSizeErrorMessage' => 'The file is too large. Allowed maximum size is 5 MiB.',
                    ])
                ],
            ])




        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
        ]);
    }
}
