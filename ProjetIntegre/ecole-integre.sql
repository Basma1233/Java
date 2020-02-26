-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.7.24 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5332
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table ecole.classe: ~5 rows (approximately)
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` (`id`, `nom`, `niveau`, `capacite`) VALUES
	(1, 'A', 3, 20),
	(2, 'B', 3, 18),
	(3, 'C', 3, 19),
	(4, 'D', 3, 18),
	(5, 'E', 3, 19);
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;

-- Dumping data for table ecole.eleve: 0 rows
/*!40000 ALTER TABLE `eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleve` ENABLE KEYS */;

-- Dumping data for table ecole.event: ~30 rows (approximately)
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`id`, `titre`, `lieu`, `nbp`, `nbparticipant`, `datedebut`, `datefin`) VALUES
	(32, 'oussemakedheb', 'arianna', 200, 200, '2020-02-02', '2020-02-02'),
	(33, 'oussema', 'arianna', 200, 0, '2020-02-02', '2020-02-02'),
	(34, 'khalil', 'tunis', 300, 0, '2020-01-01', '2020-01-01'),
	(37, 'aaa', 'arianna', 800, 0, '2020-03-03', '2020-03-04'),
	(39, 'faydra', 'sfax', 500, 0, '2020-01-01', '2020-01-02'),
	(40, 'faydra', 'sfax', 500, 0, '2020-01-01', '2020-01-02'),
	(41, 'khali', 'khalil', 12, 0, '2020-07-07', '2020-07-07'),
	(42, 'aaa', 'aaaa', 11, 0, '2020-10-10', '2020-10-10'),
	(43, 'aaaa', 'aaaa', 11, 0, '2020-10-10', '2020-10-10'),
	(44, 'aaa', 'aaa', 10, 0, '2020-10-10', '2020-10-10'),
	(45, 'aaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(46, 'aaa', 'aaaa', 20, 0, '2020-10-10', '2020-10-10'),
	(47, 'aaaa', 'aaaa', 100, 0, '2020-10-10', '2020-10-10'),
	(48, 'ahmed', 'ahmed', 20, 0, '2020-10-10', '2020-10-10'),
	(49, 'aaa', 'aaa', 10, 0, '2020-10-10', '2020-10-10'),
	(50, 'aaaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(51, 'aaa', 'aaaa', 15, 0, '2020-10-10', '2020-10-10'),
	(52, 'aaa', 'aaa', 10, 0, '2020-10-10', '2020-10-10'),
	(53, 'aaa', 'aaa', 10, 0, '2020-10-10', '2020-10-10'),
	(54, 'AAA', 'AAAA', 15, 0, '2020-10-10', '2020-10-10'),
	(55, 'AAA', 'AAA', 14, 0, '2020-10-10', '2020-10-10'),
	(56, 'aaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-15'),
	(57, 'aaa', 'aaa', 12, 0, '2020-10-10', '2020-10-10'),
	(58, 'aaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(59, 'aaa', 'aaaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(60, 'aaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(61, 'aaa', 'aaaa', 10, 0, '2020-10-10', '2020-10-10'),
	(62, 'aaa', 'aaa', 10, 0, '2020-10-10', '2020-10-10'),
	(64, 'ousss', 'lahahd', 12, 0, '2020-10-10', '2020-10-10'),
	(65, 'adafraf', 'afafaffq', 12, 0, '2020-10-10', '2020-10-10');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- Dumping data for table ecole.horaire: ~5 rows (approximately)
/*!40000 ALTER TABLE `horaire` DISABLE KEYS */;
INSERT INTO `horaire` (`id`, `nom`) VALUES
	(1, '8h-10h'),
	(2, '10h-12h'),
	(3, '12H-14h'),
	(4, '14H-16h'),
	(5, '16H-18h');
/*!40000 ALTER TABLE `horaire` ENABLE KEYS */;

-- Dumping data for table ecole.jour: ~6 rows (approximately)
/*!40000 ALTER TABLE `jour` DISABLE KEYS */;
INSERT INTO `jour` (`id`, `nom`) VALUES
	(1, 'Lundi'),
	(2, 'Mardi'),
	(3, 'Mercredi'),
	(4, 'Jeudi'),
	(5, 'Vendredi'),
	(6, 'Samedi');
/*!40000 ALTER TABLE `jour` ENABLE KEYS */;

-- Dumping data for table ecole.matiere: ~9 rows (approximately)
/*!40000 ALTER TABLE `matiere` DISABLE KEYS */;
INSERT INTO `matiere` (`id`, `nom`, `coefficient`) VALUES
	(1, 'Informatique', 3),
	(2, 'Anglais', 2),
	(3, 'Français', 4),
	(4, 'Math', 4),
	(5, 'Sciences de la vie', 3),
	(7, 'Physique', 3),
	(8, 'chimie', 2),
	(9, 'histoire', 1),
	(10, 'Géographie', 2);
/*!40000 ALTER TABLE `matiere` ENABLE KEYS */;

-- Dumping data for table ecole.parent: ~5 rows (approximately)
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` (`id`, `name`, `login`, `password`, `studentid`) VALUES
	(12, 'mouheddin', 'mahmah', '28526044', 6),
	(14, 'test', 'test', '123456', 11),
	(15, 'mahdi', 'mahdi', '12345', 4),
	(16, 'mahdi Mzoughi', 'mahdi', '12134', 11),
	(17, 'ss', 'ss', 'ss', 0);
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;

-- Dumping data for table ecole.prof: ~7 rows (approximately)
/*!40000 ALTER TABLE `prof` DISABLE KEYS */;
INSERT INTO `prof` (`id`, `nom`, `prenom`, `tel`, `email`, `adresse`, `specialite`) VALUES
	(1, 'mohamed', 'bouzid', '22286375', 'sediridhia@gmail.com', 'rue 8 marsa', 'chimie'),
	(2, 'amin', 'snaini', '22286375', 'sediridhia@gmail.com', 'rue 6 sokra', 'informatique'),
	(3, 'dhia', 'sediri', '22286375', 'sediridhia@gmail.com', 'rue 18 ariana', 'anglais'),
	(4, 'Ahmed', 'Bouzazi', '22286375', 'sediridhia@gmail.com', 'rue 16 ben aarous', 'physique'),
	(5, 'Salah', 'Wasli', '22286375', 'sediridhia@gmail.com', 'rue 10 rades', 'français'),
	(6, 'Farid', 'Rahoui', '22286375', 'sediridhia@gmail.com', 'rue 5 manzah', 'histoire'),
	(8, 'ddd', 'ddd', 'dddd', 'dddd', 'dddd', 'ddddffff');
/*!40000 ALTER TABLE `prof` ENABLE KEYS */;

-- Dumping data for table ecole.reservation: ~0 rows (approximately)
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;

-- Dumping data for table ecole.salle: ~5 rows (approximately)
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` (`id`, `nom`, `capacite`) VALUES
	(1, 'Ibn kholdoun', 20),
	(2, 'Abou kacem chebbi', 20),
	(3, 'Espoir', 18),
	(4, 'Razi', 19),
	(5, 'Al moutanabi', 20);
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;

-- Dumping data for table ecole.seance: ~7 rows (approximately)
/*!40000 ALTER TABLE `seance` DISABLE KEYS */;
INSERT INTO `seance` (`id`, `classe`, `matiere`, `salle`, `prof`, `horaire`, `jour`) VALUES
	(1, 1, 1, 1, 3, 2, 1),
	(2, 1, 2, 1, 1, 4, 1),
	(3, 1, 5, 1, 2, 5, 1),
	(4, 2, 4, 3, 1, 1, 1),
	(5, 2, 7, 3, 2, 2, 1),
	(6, 2, 8, 3, 3, 5, 1),
	(12, 5, 10, 4, 1, 2, 2);
/*!40000 ALTER TABLE `seance` ENABLE KEYS */;

-- Dumping data for table ecole.student: ~5 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `DateOfBirth`, `class`, `mail`, `sex`, `name`, `login`, `password`, `adress`) VALUES
	(4, '2020-02-05 00:00:00', 'hgv', ',hv', ',h', 'mehdi', 'medhii', 'azzaa', 'hgv'),
	(6, '2020-02-26 00:00:00', '3a9', 'aaaa@esprit.tn', 'homme', 'mahdi mzoughi', 'mzoughi', 'mahdi', 'manouba'),
	(7, '2020-02-19 00:00:00', '3a', 'aaaaa@gmail.com', 'femme', 'aaaaaaaa', 'aaa', 'aaaa', 'aaaa'),
	(10, '2020-02-12 00:00:00', 'dsfdsfsd', 'sdf', 'sdf', 'sdf', 'dsf1', 'sdf', 'dsf'),
	(11, '2020-02-19 00:00:00', '3A2', 'test1@esprit.tn', 'homme', 'test2', 'test2', 'test1', 'manouba ');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping data for table ecole.user: ~3 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `password`, `type`, `email`) VALUES
	(1, 'dhia', '123', 'admin', 'sediridhia@gmail.com'),
	(2, 'prof', 'prof', 'prof', 'mohameddhia.sediri@esprit'),
	(4, 'client', 'client', 'client', 'client@email.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
