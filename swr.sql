-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 24 fév. 2020 à 22:44
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `swr`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `idc` int(11) NOT NULL AUTO_INCREMENT,
  `nomcat` varchar(30) NOT NULL,
  PRIMARY KEY (`idc`),
  UNIQUE KEY `nomcat` (`nomcat`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`idc`, `nomcat`) VALUES
(4, 'Business'),
(11, 'Health'),
(6, 'Organizations'),
(10, 'Politic'),
(7, 'Refugees'),
(9, 'Solidarity');

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `idn` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(30) NOT NULL,
  `description` varchar(255) NOT NULL,
  `datepub` date NOT NULL,
  `nomcat` varchar(30) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`idn`),
  UNIQUE KEY `titre` (`titre`),
  KEY `nomcat` (`nomcat`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `news`
--

INSERT INTO `news` (`idn`, `titre`, `description`, `datepub`, `nomcat`, `image`) VALUES
(23, 'Human solidarity', 'First and foremost human solidarity is founded on mutual respect of each others uniqueness and a deep sense of appreciation of our common humanity', '2020-02-23', 'Solidarity', 'f_5e52c87a56520.jpg'),
(24, 'Usa politics', 'US officials reportedly told Bernie Sanders that Russia is trying to help his presidential campaign', '2020-02-23', 'Politic', 'f_5e52c98b6ef49.jpeg'),
(25, 'Corona virus', 'Coronaviruses CoV are a large family of viruses that cause illness ranging from the common cold to more severe diseases such as Middle East Respiratory Syndrome MERSCoV and Severe Acute Respiratory Syndrome SARSCoV A novel coronavirus nCoV', '2020-02-23', 'Health', 'f_5e52ca79e8b7a.jpg'),
(26, 'Solidarity business rescue', 'Solidarity takes credit for SAAs business rescue decision', '2020-02-23', 'Business', 'f_5e52cae064cec.jpg'),
(27, 'Unieco', 'UNESCO has 193 member states and 11 associate members Most of its field offices are cluster offices that cover three or more countries national and regional offices also exist', '2020-02-23', 'Organizations', 'f_5e52cb7db1043.jpg'),
(28, 'tunisia s president ', ' Vice-President of the European Parliament and Chief Observer took centre stage at a working session which President Kais Saied', '2020-02-23', 'Politic', 'f_5e52cc478de74.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idu` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tel` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `usernameCanonical` varchar(30) DEFAULT NULL,
  `emailCanonical` varchar(30) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `salt` varchar(30) DEFAULT NULL,
  `lastlogin` date DEFAULT NULL,
  `confirmationToken` varchar(30) DEFAULT NULL,
  `passwordrequestedat` varchar(30) DEFAULT NULL,
  `roles` varchar(30) NOT NULL,
  `dateins` date NOT NULL,
  `radom` varchar(255) NOT NULL,
  `iteration` int(30) NOT NULL DEFAULT '3',
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`idu`),
  UNIQUE KEY `nom` (`nom`),
  UNIQUE KEY `mail` (`email`),
  UNIQUE KEY `tel` (`tel`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `usernameCanonical` (`usernameCanonical`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `usernameCanonical`, `emailCanonical`, `enabled`, `salt`, `lastlogin`, `confirmationToken`, `passwordrequestedat`, `roles`, `dateins`, `radom`, `iteration`, `image`) VALUES
(38, 'amine', 'chourou', 'Tunisia', 'mohamedamine.chourou@esprit.tn', '$2a$10$OYty/sJuxGPcgxtIKQHiWeoYkagX0REItXtzqaAqf3R5SBytmHTIi', 99216983, 'amine97', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', '2020-02-22', '202972', 3, 'f_5e52ccfd7874e.jpg'),
(41, 'kamel', 'chourou', 'tunisie', 'kamelchourou@yahoo.fr', '$2a$10$OYty/sJuxGPcgxtIKQHiWe9ddMn0EmStEIJVxrc/uKzmX1G06hvjq', 21287713, 'chourou', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin', '2020-02-23', '397817', 3, 'f_5e52f37ec7d29.png'),
(40, 'chahro', 'kakda', 'Morroco', 'mohamedamine@esprit.tn', '$2a$10$OYty/sJuxGPcgxtIKQHiWeC6jJgPBE9uvsDb3XoJ24ujnPWNTPiie', 58247634, 'amine98', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', '2020-02-23', '303236', 3, 'f_5e52ceabecece.png'),
(42, 'dahdauda', 'daudabud', 'dahduazd', 'dhaidhaid@dada.com', '$2a$10$OYty/sJuxGPcgxtIKQHiWeKx1du1mVOLHJTAdBGPj8K9Bvw3j3TZG', 98745632, 'dahuadha85', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', '2020-02-24', '214690', 3, 'f_5e53b3fd0baae.png'),
(43, 'soulah', 'souuu', 'Tunisia', 'salahbenhamida@yahoo.fr', '$2a$10$OYty/sJuxGPcgxtIKQHiWeFHjilf23H13szZDSreMJlFPFC4M657.', 55879568, 'benhamida96', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user', '2020-02-24', '275928', 3, 'f_5e5401785e89d.jpg');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `nomcat` FOREIGN KEY (`nomcat`) REFERENCES `categorie` (`nomcat`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
