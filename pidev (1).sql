-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 02 mars 2021 à 20:43
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `centre`
--

DROP TABLE IF EXISTS `centre`;
CREATE TABLE IF NOT EXISTS `centre` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `numMaison` varchar(20) DEFAULT NULL,
  `rue` varchar(35) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `collaboration`
--

DROP TABLE IF EXISTS `collaboration`;
CREATE TABLE IF NOT EXISTS `collaboration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idDemande` int(11) NOT NULL,
  `idOffre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDemande` (`idDemande`),
  KEY `idOffre` (`idOffre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contenu` varchar(25) NOT NULL,
  `dateD` date NOT NULL,
  `dateF` date NOT NULL,
  `placeDispo` int(11) NOT NULL,
  `idEnseig` int(11) NOT NULL,
  `emploi` int(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

DROP TABLE IF EXISTS `demande`;
CREATE TABLE IF NOT EXISTS `demande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` date NOT NULL,
  `DateFin` date NOT NULL,
  `idDomaine` int(11) NOT NULL,
  `montantPropose` float NOT NULL,
  `idEcole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDomaine` (`idDomaine`),
  KEY `idEcole` (`idEcole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `discussion`
--

DROP TABLE IF EXISTS `discussion`;
CREATE TABLE IF NOT EXISTS `discussion` (
  `id_disc` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `email_login_dest` varchar(40) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `message` text,
  `image` varchar(20) DEFAULT NULL,
  `autre` varchar(20) DEFAULT NULL,
  `date_envoi` datetime NOT NULL,
  PRIMARY KEY (`id_disc`),
  KEY `fk1` (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `domaine`
--

DROP TABLE IF EXISTS `domaine`;
CREATE TABLE IF NOT EXISTS `domaine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `domform`
--

DROP TABLE IF EXISTS `domform`;
CREATE TABLE IF NOT EXISTS `domform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idForm` int(11) NOT NULL,
  `idDom` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idForm` (`idForm`),
  KEY `idDom` (`idDom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `numMaison` varchar(20) DEFAULT NULL,
  `rue` varchar(35) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salaire` float NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `idEcole` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEcole` (`idEcole`),
  KEY `idUser` (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

DROP TABLE IF EXISTS `formateur`;
CREATE TABLE IF NOT EXISTS `formateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salaire` double NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(250) NOT NULL,
  `contenu` int(11) NOT NULL,
  `placeDispo` int(11) NOT NULL,
  `idFormateur` int(11) NOT NULL,
  `idCollab` int(11) NOT NULL,
  `emploi` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFormateur` (`idFormateur`),
  KEY `idCollab` (`idCollab`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `modenseig`
--

DROP TABLE IF EXISTS `modenseig`;
CREATE TABLE IF NOT EXISTS `modenseig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idEnseig` int(11) NOT NULL,
  `idMod` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idMod` (`idMod`),
  KEY `idEnseig` (`idEnseig`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `modules`
--

DROP TABLE IF EXISTS `modules`;
CREATE TABLE IF NOT EXISTS `modules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` int(11) NOT NULL,
  `coeff` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

DROP TABLE IF EXISTS `offre`;
CREATE TABLE IF NOT EXISTS `offre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prixPropose` float NOT NULL,
  `certifie` tinyint(1) NOT NULL,
  `idCentre` int(11) NOT NULL,
  `idDemande` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCentre` (`idCentre`),
  KEY `idDemande` (`idDemande`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contenu` text NOT NULL,
  `resultat` text NOT NULL,
  `idSource` int(11) NOT NULL,
  `idReclame` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idSource` (`idSource`),
  KEY `idReclame` (`idReclame`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `respcentre`
--

DROP TABLE IF EXISTS `respcentre`;
CREATE TABLE IF NOT EXISTS `respcentre` (
  `id` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idCentre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`),
  KEY `idCentre` (`idCentre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `respecole`
--

DROP TABLE IF EXISTS `respecole`;
CREATE TABLE IF NOT EXISTS `respecole` (
  `id` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idEcole` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`),
  KEY `idEcole` (`idEcole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL,
  `cin` varchar(8) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(8) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `motDePasse` varchar(30) DEFAULT NULL,
  `numMaison` varchar(20) DEFAULT NULL,
  `rue` varchar(35) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `role` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cin` (`cin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
