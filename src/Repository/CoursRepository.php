<?php

namespace App\Repository;


use App\Entity\Cours;
use App\Entity\Formation;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Cours|null find($id, $lockMode = null, $lockVersion = null)
 * @method Cours|null findOneBy(array $criteria, array $orderBy = null)
 * @method Cours[]    findAll()
 * @method Cours[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CoursRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Cours::class);
    }

    public function  findByDate(){
        return $this->createQueryBuilder('s')
            ->andWhere('s.dateD <= ?2')
            ->setParameter(2, new \DateTime())
            ->andWhere('s.dateF >= ?3')
            ->setParameter(3, new \DateTime())
            ->getQuery()->getResult();
    }
    public function findSearch($title)
    {
        return $this->createQueryBuilder('s')
            ->where('s.titre Like ?1')
            ->setParameter(1, '%'.$title."%")
            ->andWhere('s.dateD <= ?2')
            ->setParameter(2, new \DateTime())
            ->andWhere('s.dateF >= ?3')
            ->setParameter(3, new \DateTime())
            ->getQuery()->getResult();

    }
}
