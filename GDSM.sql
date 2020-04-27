
--
-- Table structure for table `Medecin`
--

CREATE TABLE `Medecin` (
  `login` varchar(30) NOT NULL,
  `mot_de_passe` varchar(30) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `Medecin`
--

LOCK TABLES `Medecin` WRITE;
/*!40000 ALTER TABLE `Medecin` DISABLE KEYS */;
INSERT INTO `Medecin` VALUES ('Madexx','Madexx99',10),('Ibra','Moret23',12),('Abra','Abra22',13),('Fatoumata','Fatoumata55',15),('Yacine','Passer2020',18);
/*!40000 ALTER TABLE `Medecin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `groupe_sanguin` varchar(15) DEFAULT NULL,
  `maladies` text,
  `date_ajout` varchar(25) NOT NULL DEFAULT (cast(now() as date)),
  `medicaments` text,
  PRIMARY KEY (`telephone`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES ('quit','Quit;','764453355','Dior',NULL,NULL,NULL,'2020-04-14',NULL),('Malik','Imam','765554433','medina',NULL,NULL,NULL,'2020-04-15',NULL),('Mamadou','Cire Diallo','773006432','Keur Massar',NULL,NULL,NULL,'2020-04-27',NULL),('Trump','Camara','774563321','yoff',NULL,NULL,NULL,'2020-04-13 23:00:51',NULL),('alseny','Diallo','774566777','wakam',NULL,NULL,NULL,'2020-04-14',NULL),('Poutine','Vlademir','774653650','Grand yoff',NULL,'AB+',NULL,'2020-04-13',NULL),('dielya','Wane D','774659875','yoff',NULL,NULL,'Paludisme','2020-04-13 23:00:51',NULL),('Djibril','Camara','774659899','Wakam',NULL,'O+',NULL,'2020-04-13 23:06:33',NULL),('Karamoko','Camara','776549086','GT 64',NULL,NULL,NULL,'2020-04-13 23:00:51',NULL),('jgef','uwtdg','783333333','o8q7ge',32,NULL,NULL,'2020-04-27',NULL),('Emmanuel','Macron','783338899','Elyse',NULL,NULL,NULL,'2020-04-14',NULL);
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rendez_vous` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendez_vous`
--

LOCK TABLES `rendez_vous` WRITE;
/*!40000 ALTER TABLE `rendez_vous` DISABLE KEYS */;
INSERT INTO `rendez_vous` VALUES (1,'Mady','Camara','22/07/2002'),(2,'Fatoumata','Camara','22/07/2004'),(3,'abbash','Mamadou','12/8/2020'),(4,'lol','ahah','3/2/2020'),(5,'vhgh','234','4/4/2020'),(6,'mhf45','459','5/3/2022'),(7,'madexx','camaro','5/6/2022'),(8,'hulker','forder','3/5/2020'),(9,'Abba','Camara','30/4/2044'),(10,'Emmanuel','Macron','14/5/2020'),(11,'alseny','Diallo','23/4/2020'),(12,'lolo','lolo','13/9/2020'),(13,'Mamadou','cire Diallo','27/4/2020');
/*!40000 ALTER TABLE `rendez_vous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Secretaire`
--

DROP TABLE IF EXISTS `Secretaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Secretaire` (
  `login` varchar(30) NOT NULL,
  `mot_de_passe` varchar(30) NOT NULL,
  `Fonction` varchar(15) DEFAULT 'Secretaire',
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
