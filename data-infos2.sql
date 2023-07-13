-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 01 juin 2023 à 01:12
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `data-infos2`
--

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `codeM` varchar(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `dateNaissance` varchar(30) NOT NULL,
  `lieuNaissance` varchar(20) NOT NULL,
  `lesmodules` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `filier` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`codeM`, `nom`, `prenom`, `dateNaissance`, `lieuNaissance`, `lesmodules`, `filier`) VALUES
('k12132030', 'mos', 'fati', '09el/03/2018', 'jadida', 'M4', 'M4'),
('J302010', 'kabli', 'salma', '01/01/2000', 'casa', 'M3', 'M3'),
('ddd', 'ddd', 'ddd', '10/01/2000', 'casa', 'M2,M5,', ' '),
('J220133', 'karim', 'ahmed', '20/10/2003', 'tanger', 'M1,M2,', ' '),
('F102030', 'ahmed', 'ahmed', '10/10/2000', 'casa', 'M2,', ' '),
('k201030', 'lllll', 'hhh', '20/03/2003', 'casa', 'M1,M2,', ' '),
('G12132132', 'kkkkk', 'mmmm', '04/05/1999', 'eljadida', 'M2,', ' '),
('K3140203', 'koko', 'mona', '03/03/1990', 'marrakech', 'M2,', 'SMP');

-- --------------------------------------------------------

--
-- Structure de la table `user1`
--

DROP TABLE IF EXISTS `user1`;
CREATE TABLE IF NOT EXISTS `user1` (
  `nom` varchar(30) NOT NULL,
  `prenome` varchar(30) NOT NULL,
  `motepasse` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user1`
--

INSERT INTO `user1` (`nom`, `prenome`, `motepasse`) VALUES
('mos', 'fati', '123'),
('pa', 'zahra', '222'),
('kabli', 'salma', '222'),
('ddd', 'ahmed', '333');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
