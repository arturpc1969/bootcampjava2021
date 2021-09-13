CREATE TABLE `autores` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(50),
  `email` varchar(50),
  `data_nascimento` date,
  `mini_curriculo` text
);
