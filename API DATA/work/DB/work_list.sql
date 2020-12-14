-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2020 at 12:34 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `work`
--

-- --------------------------------------------------------

--
-- Table structure for table `work_list`
--

CREATE TABLE `work_list` (
  `id` int(11) NOT NULL,
  `tittle` longtext NOT NULL,
  `descr` longtext NOT NULL,
  `priority` longtext NOT NULL,
  `work_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `work_list`
--

INSERT INTO `work_list` (`id`, `tittle`, `descr`, `priority`, `work_date`) VALUES
(1, 'Testing 1', 'Work 1 description data', 'low', '2020-12-16'),
(2, 'Testing 2', 'Work 2 description data', 'high', '2020-12-15'),
(13, 'hello 1', 'hello 2', '', '0000-00-00'),
(14, 'hello 1', 'hello 2', '', '0000-00-00'),
(15, 'test jg', 'hello', '', '0000-00-00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `work_list`
--
ALTER TABLE `work_list`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `work_list`
--
ALTER TABLE `work_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
