<?php

namespace App\Repository;


use App\Entity\Centre;
use App\Entity\DomaineFormateur;
use App\Entity\EtudiantFormation;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method DomaineFormateur|null find($id, $lockMode = null, $lockVersion = null)
 * @method DomaineFormateur|null findOneBy(array $criteria, array $orderBy = null)
 * @method DomaineFormateur[]    findAll()
 * @method DomaineFormateur[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class DomaineFormateurRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, DomaineFormateur::class);
    }




}
