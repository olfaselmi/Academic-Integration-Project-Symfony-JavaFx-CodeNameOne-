<?php


namespace App\Entity;
use App\Repository\CoursRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=CoursRepository::class)
 */
class Cours
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
     * @ORM\Column(type="text")
     */
    private $contenu;
    /**
     * @ORM\Column(name="dateD",type="date")
     */
    private $dateD;
    /**
     * @ORM\Column(name="dateF",type="date")
     */
    private $dateF;
    /**
     * @ORM\Column(name="placeDispo", type="string", length=25)
     */
    private $placeDispo;
    /**
     * @ORM\Column( type="string", length=250)
     */
    private $image;
    /**
     * @ORM\Column( type="string", length=250)
     */
    private $file;
    /**
     * @ORM\ManyToOne(targetEntity=Enseignant::class, inversedBy="cours")
     * @ORM\JoinColumn(name="idEnseig")
     */
    private $enseignant;
    /**
     * @ORM\OneToMany(targetEntity=EtudiantFormation::class, mappedBy="cours")
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
    public function getDateD()
    {
        return $this->dateD;
    }

    /**
     * @param mixed $dateD
     */
    public function setDateD($dateD): void
    {
        $this->dateD = $dateD;
    }

    /**
     * @return mixed
     */
    public function getDateF()
    {
        return $this->dateF;
    }

    /**
     * @param mixed $dateF
     */
    public function setDateF($dateF): void
    {
        $this->dateF = $dateF;
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
    public function getEnseignant()
    {
        return $this->enseignant;
    }

    /**
     * @param mixed $enseignant
     */
    public function setEnseignant($enseignant): void
    {
        $this->enseignant = $enseignant;
    }

    public function getFirst100(){
        $str= substr($this->getContenu(), 0, 100);
        return $str;
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