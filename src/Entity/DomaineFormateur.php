<?php


namespace App\Entity;
use App\Repository\DomaineFormateurRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=DomaineFormateurRepository::class)
 */
class DomaineFormateur
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\ManyToOne(targetEntity=Domaine::class, inversedBy="domaineFormateurs")
     * @ORM\JoinColumn(name="idDomaine")
     */
    private $domaine;
    /**
     * @ORM\ManyToOne(targetEntity=Formateur::class, inversedBy="domaineFormateurs")
     * @ORM\JoinColumn(name="idFormateur")
     */
    private $formateur;

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
    public function getDomaine()
    {
        return $this->domaine;
    }

    /**
     * @param mixed $domaine
     */
    public function setDomaine($domaine): void
    {
        $this->domaine = $domaine;
    }

    /**
     * @return mixed
     */
    public function getFormateur()
    {
        return $this->formateur;
    }

    /**
     * @param mixed $formateur
     */
    public function setFormateur($formateur): void
    {
        $this->formateur = $formateur;
    }


}