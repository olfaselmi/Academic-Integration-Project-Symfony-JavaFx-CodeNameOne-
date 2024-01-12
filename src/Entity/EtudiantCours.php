<?php


namespace App\Entity;
use App\Repository\EtudiantCoursRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=EtudiantCoursRepository::class)
 */
class EtudiantCours
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\ManyToOne(targetEntity=Cours::class, inversedBy="etudiantCours")
     * @ORM\JoinColumn(name="idCours")
     */
    private $cours;
    /**
     * @ORM\ManyToOne(targetEntity=Etudiant::class, inversedBy="etudiantCours")
     * @ORM\JoinColumn(name="idEtudiant")
     */
    private $etudiant;

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id): void
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getCours()
    {
        return $this->cours;
    }

    /**
     * @param mixed $cours
     */
    public function setCours($cours): void
    {
        $this->cours = $cours;
    }



    /**
     * @return mixed
     */
    public function getEtudiant()
    {
        return $this->etudiant;
    }

    /**
     * @param mixed $etudiant
     */
    public function setEtudiant($etudiant): void
    {
        $this->etudiant = $etudiant;
    }


}