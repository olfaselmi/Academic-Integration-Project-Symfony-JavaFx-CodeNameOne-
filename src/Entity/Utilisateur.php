<?php


namespace App\Entity;
use App\Repository\UtilisateurRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=UtilisateurRepository::class)
 */
class Utilisateur
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;
    /**
     * @ORM\Column(type="string", length=8)
     */
    private $cin;
    /**
     * @ORM\Column(type="string", length=30)
     */
    private $nom;
    /**
     * @ORM\Column(type="string", length=30)
     */
    private $prenom;
    /**
     * @ORM\Column(type="integer")
     */
    private $age;
    /**
     * @ORM\Column(type="string", length=8)
     */
    private $tel;
    /**
     * @ORM\Column(type="string", length=30)
     */
    private $email;
    /**
     * @ORM\Column(name="motDePasse", type="string", length=30)
     */
    private $motDePasse;
    /**
     * @ORM\Column(name="numMaison", type="string", length=20)
     */
    private $numMaison;
    /**
     * @ORM\Column(type="string", length=35)
     */
    private $rue;
    /**
     * @ORM\Column( type="string", length=20)
     */
    private $ville;
    /**
     * @ORM\Column( type="string", length=25)
     */
    private $role;
    /**
     * @ORM\OneToMany(targetEntity=Formateur::class, mappedBy="utilisateur")
     */
    private $formateur;
    /**
     * @ORM\OneToMany(targetEntity=Enseignant::class, mappedBy="utilisateur")
     */
    private $enseignant;
    /**
     * @ORM\OneToMany(targetEntity=Etudiant::class, mappedBy="utilisateur")
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
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * @param mixed $cin
     */
    public function setCin($cin): void
    {
        $this->cin = $cin;
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
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * @param mixed $prenom
     */
    public function setPrenom($prenom): void
    {
        $this->prenom = $prenom;
    }

    /**
     * @return mixed
     */
    public function getAge()
    {
        return $this->age;
    }

    /**
     * @param mixed $age
     */
    public function setAge($age): void
    {
        $this->age = $age;
    }

    /**
     * @return mixed
     */
    public function getTel()
    {
        return $this->tel;
    }

    /**
     * @param mixed $tel
     */
    public function setTel($tel): void
    {
        $this->tel = $tel;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email): void
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getMotDePasse()
    {
        return $this->motDePasse;
    }

    /**
     * @param mixed $motDePasse
     */
    public function setMotDePasse($motDePasse): void
    {
        $this->motDePasse = $motDePasse;
    }

    /**
     * @return mixed
     */
    public function getNumMaison()
    {
        return $this->numMaison;
    }

    /**
     * @param mixed $numMaison
     */
    public function setNumMaison($numMaison): void
    {
        $this->numMaison = $numMaison;
    }

    /**
     * @return mixed
     */
    public function getRue()
    {
        return $this->rue;
    }

    /**
     * @param mixed $rue
     */
    public function setRue($rue): void
    {
        $this->rue = $rue;
    }

    /**
     * @return mixed
     */
    public function getVille()
    {
        return $this->ville;
    }

    /**
     * @param mixed $ville
     */
    public function setVille($ville): void
    {
        $this->ville = $ville;
    }

    /**
     * @return mixed
     */
    public function getRole()
    {
        return $this->role;
    }

    /**
     * @param mixed $role
     */
    public function setRole($role): void
    {
        $this->role = $role;
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