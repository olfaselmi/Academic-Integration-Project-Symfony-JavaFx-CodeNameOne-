<?php

namespace App\Repository;


use App\Entity\EtudiantCours;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method EtudiantCours|null find($id, $lockMode = null, $lockVersion = null)
 * @method EtudiantCours|null findOneBy(array $criteria, array $orderBy = null)
 * @method EtudiantCours[]    findAll()
 * @method EtudiantCours[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EtudiantCoursRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, EtudiantCours::class);
    }




}
