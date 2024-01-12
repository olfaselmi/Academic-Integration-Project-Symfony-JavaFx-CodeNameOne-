<?php


namespace App\Entity;
use App\Repository\FormateurRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=FormateurRepository::class)
 */
class Formateur
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\Column(type="float")
     */
    private $salaire;
    /**
     * @ORM\ManyToOne(targetEntity=Utilisateur::class, inversedBy="formateur")
     * @ORM\JoinColumn(name="idUser")
     */
    private $utilisateur;
    /**
     * @ORM\OneToMany(targetEntity=Formation::class, mappedBy="formateur")
     */
    private $formations;

    /**
     * @ORM\OneToMany(targetEntity=DomaineFormateur::class, mappedBy="formateur")
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
    public function getSalaire()
    {
        return $this->salaire;
    }

    /**
     * @param mixed $salaire
     */
    public function setSalaire($salaire): void
    {
        $this->salaire = $salaire;
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
    public function getFormations()
    {
        return $this->formations;
    }

    /**
     * @param mixed $formations
     */
    public function setFormations($formations): void
    {
        $this->formations = $formations;
    }

    public function __toString()
    {
        return $this->utilisateur->getPrenom()." ".$this->utilisateur->getNom();
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

    public function getDomaines(){
        $res="";
        foreach($this->getDomaineFormateurs() as $val){
            $res=$res." / ".$val->getDomaine()->getNom();
        }
        return $res;
    }


}