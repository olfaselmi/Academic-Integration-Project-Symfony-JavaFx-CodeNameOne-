<?php


namespace App\Entity;
use App\Repository\CentreRepository;
use Com\Tecnick\Barcode\Barcode;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
/**
 * @ORM\Entity(repositoryClass=CentreRepository::class)
 */
class Centre
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
     * @ORM\Column( type="string",name="numMaison", length=20)
     */
    private $numMaison;
    /**
     * @ORM\Column( type="string", length=20)
     */
    private $ville;
    /**
     * @ORM\Column( type="string", length=35)
     */
    private $rue;
    /**
     * @ORM\Column( type="string", length=250)
     */
    private $file;
    /**
     * @ORM\ManyToOne(targetEntity=Domaine::class, inversedBy="centres")
     */
    private $domaine;

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

    public function getQrcode(){
        $barcode = new Barcode();
        $bobj = $barcode->getBarcodeObj('QRCODE,H',        $this->numMaison.' ,'. $this->rue.' ,'.$this->ville
            , -4, -4, 'black', array(-2, -2, -2, -2))->setBackgroundColor('#f0f0f0');
        return "data:image/png;base64,".base64_encode($bobj->getPngData());
    }



}