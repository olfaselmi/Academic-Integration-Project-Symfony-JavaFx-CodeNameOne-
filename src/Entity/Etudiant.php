<?php


namespace App\Entity;
use App\Repository\EtudiantRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=EtudiantRepository::class)
 */
class Etudiant
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\ManyToOne(targetEntity=Utilisateur::class, inversedBy="etudiant")
     * @ORM\JoinColumn(name="idUser")
     */
    private $utilisateur;
    /**
     * @ORM\Column(type="boolean")
     */
    private $active;
    /**
     * @ORM\Column( type="string", length=20)
     */
    private $niveau;
    /**
     * @ORM\OneToMany(targetEntity=EtudiantFormation::class, mappedBy="formation")
     */
    private $etudiantFormations;

    /**
     * @ORM\OneToMany(targetEntity=EtudiantCours::class, mappedBy="etudiant")
     */
    private $etudiantCours;

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
    public function getUtilisateur()
    {
        return $this->utilisateur;
    }

    /**
     * @param mixed $utilisateur
     */
    public function setUtilisateur($utilisateur): void
    {
        $this->utilisateur = $utilisateur;
    }

    /**
     * @return mixed
     */
    public function getActive()
    {
        return $this->active;
    }

    /**
     * @param mixed $active
     */
    public function setActive($active): void
    {
        $this->active = $active;
    }

    /**
     * @return mixed
     */
    public function getNiveau()
    {
        return $this->niveau;
    }

    /**
     * @param mixed $niveau
     */
    public function setNiveau($niveau): void
    {
        $this->niveau = $niveau;
    }

    /**
     * @return mixed
     */
    public function getEtudiantFormations()
    {
        return $this->etudiantFormations;
    }

    /**
     * @param mixed $etudiantFormations
     */
    public function setEtudiantFormations($etudiantFormations): void
    {
        $this->etudiantFormations = $etudiantFormations;
    }


    public function __toString()
    {
        return $this->utilisateur->getPrenom()." ".$this->utilisateur->getNom();
    }

    /**
     * @return mixed
     */
    public function getEtudiantCours()
    {
        return $this->etudiantCours;
    }

    /**
     * @param mixed $etudiantCours
     */
    public function setEtudiantCours($etudiantCours): void
    {
        $this->etudiantCours = $etudiantCours;
    }



}