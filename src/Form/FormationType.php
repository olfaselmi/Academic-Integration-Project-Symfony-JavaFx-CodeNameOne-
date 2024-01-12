<?php


namespace App\Form;


use App\Entity\Formateur;
use App\Repository\FormateurRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\File;

class FormationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('titre', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Titre'
                ],
                'required' => true,

            ])
            ->add('contenu', TextareaType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Coentue'
                ],
                'required' => true,
            ])
            ->add('placeDispo', TextType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Place Disponible'
                ],
                'required' => true,
            ])
            ->add('formateur', EntityType::class, [
                'class' => Formateur::class,
                'query_builder' => function (FormateurRepository $formateurRepository) {
                    return $formateurRepository->findFormateurs();
                },
                'required' => true,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition',

                ],
                'placeholder' => 'Select Formateur'
            ])
            ->add('image', FileType::class, [
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
            ->add('file', FileType::class, [
                'attr' => [
                    'class' => 'form-control',
                ],
                'label' => 'Upload your File',
                'mapped' => false,
                'required' => true,
                'constraints' => [
                    new File([
                        'maxSize' => '5M',
                        'mimeTypes' => [
                            'application/pdf',
                            'application/x-pdf',
                            'application/msword',
                            'application/msword',
                            'application/vnd.openxmlformats-officedocument.wordprocessingml.document',
                            'application/vnd.openxmlformats-officedocument.wordprocessingml.template',
                            'image/png',
                            'application/x-latex',
                            'image/jpeg',

                        ],
                        'mimeTypesMessage' => 'Please upload a valid PDF, Doc, JPEG, PNG or LATEX file',
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
