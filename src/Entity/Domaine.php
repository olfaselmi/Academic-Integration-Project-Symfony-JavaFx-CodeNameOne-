<?php


namespace App\Entity;
use App\Repository\DomaineRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=DomaineRepository::class)
 */
class Domaine
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column( type="string", length=30)
     */
    private $nom;
    /**
     * @ORM\OneToMany(targetEntity=Centre::class, mappedBy="domaine")
     */
    private $centres;

    /**
     * @ORM\OneToMany(targetEntity=DomaineFormateur::class, mappedBy="domaine")
     */
    private $domaineFormateurs;

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
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @param mixed $nom
     */
    public function setNom($nom): void
    {
        $this->nom = $nom;
    }

    /**
     * @return mixed
     */
    public function getCentres()
    {
        return $this->centres;
    }

    /**
     * @param mixed $centres
     */
    public function setCentres($centres): void
    {
        $this->centres = $centres;
    }

    public function __toString()
    {
        return $this->nom;
    }

    /**
     * @return mixed
     */
    public function getDomaineFormateurs()
    {
        return $this->domaineFormateurs;
    }

    /**
     * @param mixed $domaineFormateurs
     */
    public function setDomaineFormateurs($domaineFormateurs): void
    {
        $this->domaineFormateurs = $domaineFormateurs;
    }

}