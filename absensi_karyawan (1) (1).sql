-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2023 at 02:43 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `absensi_karyawan`
--

-- --------------------------------------------------------

--
-- Table structure for table `absen_keluar`
--

CREATE TABLE `absen_keluar` (
  `id_karyawanq` varchar(8) NOT NULL,
  `timer` varchar(20) NOT NULL,
  `dater` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `absen_keluar`
--

INSERT INTO `absen_keluar` (`id_karyawanq`, `timer`, `dater`) VALUES
('123qq', '01-47-11', '11-06-2023'),
('123qq', '01-47-13', '11-06-2023'),
('123qq', '01-47-14', '11-06-2023'),
('123qq', '05-30-17', '13-06-2023'),
('123qq', '05-34-42', '13-06-2023');

-- --------------------------------------------------------

--
-- Table structure for table `absen_masuk`
--

CREATE TABLE `absen_masuk` (
  `id_karyawana` varchar(8) NOT NULL,
  `time` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `absen_masuk`
--

INSERT INTO `absen_masuk` (`id_karyawana`, `time`, `date`) VALUES
('123qq', '01-45-54', '11-06-2023'),
('123qq', '05-30-14', '13-06-2023'),
('123qq', '05-32-04', '13-06-2023'),
('123qq', '05-34-37', '13-06-2023');

-- --------------------------------------------------------

--
-- Table structure for table `accepted_izin`
--

CREATE TABLE `accepted_izin` (
  `id_karyawan` varchar(8) NOT NULL,
  `alasan` varchar(15) NOT NULL,
  `detail` varchar(30) NOT NULL,
  `mulaitanggal` varchar(20) NOT NULL,
  `hinggatanggal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accepted_izin`
--

INSERT INTO `accepted_izin` (`id_karyawan`, `alasan`, `detail`, `mulaitanggal`, `hinggatanggal`) VALUES
('', '-', '', '', ''),
('', '-', '', '', ''),
('123qq', 'sakit', 'qdsadas', '12', '12');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_login` int(10) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_login`, `username`, `password`) VALUES
(1, 'admin', 'qwerty123');

-- --------------------------------------------------------

--
-- Table structure for table `data_karyawan`
--

CREATE TABLE `data_karyawan` (
  `id_karyawan` varchar(8) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `kontak` varchar(15) NOT NULL,
  `pin` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_karyawan`
--

INSERT INTO `data_karyawan` (`id_karyawan`, `nama`, `jabatan`, `jenis_kelamin`, `kontak`, `pin`) VALUES
('12345as', 'ikdawn', 'supervisor', 'laki-laki', '312311', 123123),
('12345ii', 'wqebqwb', 'ceo', 'laki-laki', '2312312', 123),
('123aa', 'ikhwan n', 'office boy', 'transformer', '312312', 123456),
('123qq', 'qwer', 'ceo', 'laki-laki', '1234', 123123);

-- --------------------------------------------------------

--
-- Table structure for table `izin`
--

CREATE TABLE `izin` (
  `id_karyawan` varchar(8) NOT NULL,
  `alasan` varchar(15) NOT NULL,
  `detail` varchar(30) NOT NULL,
  `mulaitanggal` varchar(20) NOT NULL,
  `hinggatanggal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `izin`
--

INSERT INTO `izin` (`id_karyawan`, `alasan`, `detail`, `mulaitanggal`, `hinggatanggal`) VALUES
('123qq', 'sakit', '', '12/12/12', '12/12/12'),
('123qq', 'sakit', 'qdsadas', '12', '12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accepted_izin`
--
ALTER TABLE `accepted_izin`
  ADD KEY `id_karyawan` (`id_karyawan`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_login`);

--
-- Indexes for table `data_karyawan`
--
ALTER TABLE `data_karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `izin`
--
ALTER TABLE `izin`
  ADD KEY `idkaryawanz` (`id_karyawan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_login` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
