<?php


namespace App\Entity;
use App\Repository\FormationRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=FormationRepository::class)
 */
class Formation
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\Column( type="string", length=255)
     */
    private $titre;
    /**
     * @ORM\Column( type="string", length=250)
     */
    private $image;
    /**
     * @ORM\Column( type="string", length=250)
     */
    private $file;
    /**
     * @ORM\Column(type="text")
     */
    private $contenu;
    /**
     * @ORM\Column(name="placeDispo", type="string", length=250)
     */
    private $placeDispo;

    /**
     * @ORM\ManyToOne(targetEntity=Formateur::class, inversedBy="formations")
     * @ORM\JoinColumn(name="idFormateur")
     */
    private $formateur;

    /**
     * @ORM\OneToMany(targetEntity=EtudiantFormation::class, mappedBy="etudiant")
     */
    private $etudiantFormations;

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
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * @param mixed $titre
     */
    public function setTitre($titre): void
    {
        $this->titre = $titre;
    }

    /**
     * @return mixed
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * @param mixed $image
     */
    public function setImage($image): void
    {
        $this->image = $image;
    }

    /**
     * @return mixed
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * @param mixed $contenu
     */
    public function setContenu($contenu): void
    {
        $this->contenu = $contenu;
    }

    /**
     * @return mixed
     */
    public function getPlaceDispo()
    {
        return $this->placeDispo;
    }

    /**
     * @param mixed $placeDispo
     */
    public function setPlaceDispo($placeDispo): void
    {
        $this->placeDispo = $placeDispo;
    }

    /**
     * @return mixed
     */
    public function getFile()
    {
        return $this->file;
    }

    /**
     * @param mixed $file
     */
    public function setFile($file): void
    {
        $this->file = $file;
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

    public function getFirst100(){
        $str= substr($this->getContenu(), 0, 100);
        return $str;
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


}