-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2020 at 04:34 PM
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
  `priority_cat` int(11) NOT NULL,
  `work_image` longtext NOT NULL,
  `work_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `work_list`
--

INSERT INTO `work_list` (`id`, `tittle`, `descr`, `priority`, `priority_cat`, `work_image`, `work_date`) VALUES
(1, 'Monday work', 'the Monday work will be done by Engineers', 'Medium', 2, 'http://192.168.43.126/work//images/medium.png', '2020-05-20'),
(2, 'Tuesday Work', 'the Tuesday work will be done by Engineers', 'Low', 1, 'http://192.168.43.126/work//images/low.png', '2020-05-21'),
(3, 'Wednesday', 'this work will require man power so you are obligated to be fit', 'High', 3, 'http://192.168.43.126/work//images/high.jpg', '2020-08-22'),
(4, 'Thursday work', 'the Monday work will be done by Engineers', 'Medium', 2, 'http://192.168.43.126/work//images/medium.png', '2020-05-23'),
(5, 'Friday Work', 'the Tuesday work will be done by Engineers', 'Low', 1, 'http://192.168.43.126/work//images/low.png', '2020-05-24'),
(6, 'Saturday', 'this work will require man power so you are obligated to be fit', 'High', 3, 'http://192.168.43.126/work//images/high.jpg', '2020-08-25'),
(7, 'Thursday work', 'the Monday work will be done by Engineers', 'Medium', 2, 'http://192.168.43.126/work//images/medium.png', '2020-05-26'),
(8, 'Friday Work', 'the Tuesday work will be done by Engineers', 'Low', 1, 'http://192.168.43.126/work//images/low.png', '2020-05-27'),
(9, 'Saturday', 'this work will require man power so you are obligated to be fit', 'High', 3, 'http://192.168.43.126/work//images/high.jpg', '2020-08-28');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
