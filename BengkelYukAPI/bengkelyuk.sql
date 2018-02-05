-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2017 at 02:26 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bengkelyuk`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_booking`
--

CREATE TABLE `tb_booking` (
  `id_booking` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_bengkel` int(11) NOT NULL,
  `id_tipe_motor` int(11) NOT NULL,
  `tanggal_service` datetime NOT NULL,
  `keluhan` text NOT NULL,
  `status_checked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_data_bengkel`
--

CREATE TABLE `tb_data_bengkel` (
  `id_bengkel` int(11) NOT NULL,
  `nama_bengkel` text NOT NULL,
  `alamat_bengkel` text NOT NULL,
  `no_telp` int(14) NOT NULL,
  `hari_buka` text NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_merk_motor`
--

CREATE TABLE `tb_merk_motor` (
  `id_merk_motor` int(11) NOT NULL,
  `nama_merk` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_tipe_motor`
--

CREATE TABLE `tb_tipe_motor` (
  `id_tipe_motor` int(11) NOT NULL,
  `id_merk_motor` int(11) NOT NULL,
  `nama_tipe` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(60) NOT NULL,
  `no_telp` int(14) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_booking`
--
ALTER TABLE `tb_booking`
  ADD PRIMARY KEY (`id_booking`);

--
-- Indexes for table `tb_data_bengkel`
--
ALTER TABLE `tb_data_bengkel`
  ADD PRIMARY KEY (`id_bengkel`);

--
-- Indexes for table `tb_merk_motor`
--
ALTER TABLE `tb_merk_motor`
  ADD PRIMARY KEY (`id_merk_motor`);

--
-- Indexes for table `tb_tipe_motor`
--
ALTER TABLE `tb_tipe_motor`
  ADD PRIMARY KEY (`id_tipe_motor`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_booking`
--
ALTER TABLE `tb_booking`
  MODIFY `id_booking` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_data_bengkel`
--
ALTER TABLE `tb_data_bengkel`
  MODIFY `id_bengkel` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_merk_motor`
--
ALTER TABLE `tb_merk_motor`
  MODIFY `id_merk_motor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_tipe_motor`
--
ALTER TABLE `tb_tipe_motor`
  MODIFY `id_tipe_motor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
