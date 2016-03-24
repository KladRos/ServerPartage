-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2016 at 02:11 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `partage`
--

-- --------------------------------------------------------

--
-- Table structure for table `documents`
--

CREATE TABLE `documents` (
  `idFile` int(11) NOT NULL,
  `nameFile` varchar(40) NOT NULL,
  `type` varchar(5) DEFAULT NULL,
  `owner` varchar(20) NOT NULL DEFAULT '',
  `statut` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `documents`
--

INSERT INTO `documents` (`idFile`, `nameFile`, `type`, `owner`, `statut`) VALUES
(1, '12.txt', NULL, 'bob', ''),
(2, 'partager2', NULL, 'bob', 'priv'),
(3, 'partager3', NULL, 'bob', 'priv'),
(4, 'abd', NULL, 'a', 'pub'),
(5, 'partager5', NULL, 'bob', 'priv'),
(6, 'avcx', NULL, 'a', 'priv'),
(7, 'abd', NULL, 'a', 'pub'),
(8, 'a1234', NULL, 'bob', 'priv'),
(9, 'eula', '.1028', 'bob', 'priv'),
(10, 'eula1041txt', '.txt', 'bob', 'priv'),
(11, 'installres1033', '.dll', 'bob', 'priv'),
(12, 'install.res.1040', '.dll', 'bob', 'priv');

-- --------------------------------------------------------

--
-- Table structure for table `namefile`
--

CREATE TABLE `namefile` (
  `fileName` varchar(20) NOT NULL,
  `idFile` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sharedfiles`
--

CREATE TABLE `sharedfiles` (
  `idFile` int(20) NOT NULL,
  `associate` varchar(20) NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='fichier partagés';

--
-- Dumping data for table `sharedfiles`
--

INSERT INTO `sharedfiles` (`idFile`, `associate`, `owner`) VALUES
(2, 'a', 'bob'),
(3, 'a', 'bob'),
(5, 'a', 'bob'),
(6, 'bob', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(25) NOT NULL DEFAULT '',
  `password` varchar(25) DEFAULT NULL,
  `idUser` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `idUser`) VALUES
('bob', 'bob', 'bob'),
('a', 'a', 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`idFile`,`owner`);

--
-- Indexes for table `namefile`
--
ALTER TABLE `namefile`
  ADD PRIMARY KEY (`fileName`,`idFile`);

--
-- Indexes for table `sharedfiles`
--
ALTER TABLE `sharedfiles`
  ADD PRIMARY KEY (`idFile`,`associate`,`owner`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`,`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `documents`
--
ALTER TABLE `documents`
  MODIFY `idFile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `namefile`
--
ALTER TABLE `namefile`
  MODIFY `idFile` int(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
