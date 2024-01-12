<?php

namespace App\Form;

use App\Entity\Event;
use App\Entity\Product;
use App\Repository\EventRepository;
use App\Repository\ProductRepository;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\CheckboxType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\CountryType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\Extension\Core\Type\NumberType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints;
use Symfony\Component\Validator\Context\ExecutionContextInterface;
class PromotionType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('descriptionpromotion', TextareaType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'Description of promotion'

                ],
                'required' => false,

            ])

            ->add('startDatePromotion', DateType::class, [
                'attr' => [
                    'class' => 'form-control datepicker',
                    'placeholder'=>'dd/mm/yyyy'

                ],
                'constraints' => [
                    new Constraints\NotBlank(),
                    new Constraints\DateTime(),
                    new Constraints\Callback(function($object, ExecutionContextInterface $context) {
                        $start = $object;

                            if ($start->format('U') - (new \DateTime())->format('U')+86400 <= 0) {
                                $context
                                    ->buildViolation('Start date must be after today date')
                                    ->addViolation();
                            }

                    }),
                ],
                'widget' => 'single_text',
                'required' => true
            ])
            ->add('endDatePromotion', DateType::class, [
                'attr' => [
                    'class' => 'form-control datepicker',
                    'placeholder'=>'dd/mm/yyyy'

                ],
                'constraints' => [
                    new Constraints\NotBlank(),
                    new Constraints\DateTime(),
                    new Constraints\Callback(function($object, ExecutionContextInterface $context) {
                        $start = $context->getRoot()->getData()->getStartDatePromotion();
                        $stop = $object;

                        if (is_a($start, \DateTime::class) && is_a($stop, \DateTime::class)) {
                            if ($stop->format('U') - $start->format('U') < 0) {
                                $context
                                    ->buildViolation('End date must be after start date')
                                    ->addViolation();
                            }
                        }
                    }),
                ],
                'widget' => 'single_text',
                'required' => true

            ])
            ->add('pourcentage', NumberType::class, [
                'attr' => [
                    'class' => 'form-control',
                    'placeholder'=>'percentage of promotion'

                ],
                'required' => true
            ])
            ->add('event', EntityType::class, [
                'class' => Event::class,
                'query_builder' => function (EventRepository $eventRepository) {
                    return $eventRepository->findEvents();
                },
                'required' => false,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition',

                ],
                'placeholder' => 'Select Event'
            ])
            ->add('product', EntityType::class, [
                'class' => Product::class,
                'query_builder' => function (ProductRepository $productRepository) {
                    return $productRepository->findProducts();
                },
                'required' => false,
                'attr' => [
                    'class' => 'form-control',
                    'data-style' => 'select-with-transition',

                ],
                'placeholder' => 'Select Product'
            ])


        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
        ]);
    }
}
