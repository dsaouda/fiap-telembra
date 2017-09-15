-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 15/09/2017 às 16:22
-- Versão do servidor: 5.6.33-0ubuntu0.14.04.1-log
-- Versão do PHP: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `fiap_lembrou`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=10 ;

--
-- Fazendo dump de dados para tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `ativo`) VALUES
(1, 'teste', 0),
(2, 'teste', 0),
(3, 'teste', 0),
(4, 'teste', 0),
(5, 'teste', 0),
(6, 'teste', 0),
(7, 'teste', 0),
(8, 'teste', 0),
(9, 'teste', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `lembrete`
--

CREATE TABLE IF NOT EXISTS `lembrete` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `id_pessoa` bigint(20) unsigned NOT NULL,
  `dt_enviar_lembrete` datetime NOT NULL,
  `dt_lembrete_enviado` datetime DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status_mensagem` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mensagem` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=10 ;

--
-- Fazendo dump de dados para tabela `lembrete`
--

INSERT INTO `lembrete` (`id`, `id_cliente`, `id_pessoa`, `dt_enviar_lembrete`, `dt_lembrete_enviado`, `status`, `status_mensagem`, `mensagem`) VALUES
(1, 1, 1, '2017-09-09 18:12:19', NULL, NULL, '', 'Olá, isso é um teste'),
(2, 2, 2, '2017-09-09 18:15:09', NULL, NULL, '', 'Olá, isso é um teste'),
(3, 3, 3, '2017-09-09 18:15:11', NULL, NULL, '', 'Olá, isso é um teste'),
(4, 4, 4, '2017-09-09 18:15:18', NULL, NULL, '', 'Olá, isso é um teste'),
(5, 5, 5, '2017-09-09 23:08:56', NULL, NULL, '', 'Olá, isso é um teste'),
(6, 6, 6, '2017-09-09 23:28:17', NULL, NULL, '', 'Olá, isso é um teste'),
(7, 7, 7, '2017-09-09 23:28:57', NULL, NULL, '', 'Olá, isso é um teste'),
(8, 8, 8, '2017-09-09 23:29:32', NULL, NULL, '', 'Olá, isso é um teste'),
(9, 9, 9, '2017-09-09 23:31:13', NULL, NULL, '', 'Olá, isso é um teste');

-- --------------------------------------------------------

--
-- Estrutura para tabela `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=10 ;

--
-- Fazendo dump de dados para tabela `login`
--

INSERT INTO `login` (`id`, `id_cliente`, `nome`, `email`, `senha`) VALUES
(1, 1, 'Di', 'diegosaouda@gmail.com', '123'),
(2, 2, 'Di', 'diegosaouda@gmail.com', '123'),
(3, 3, 'Di', 'diegosaouda@gmail.com', '123'),
(4, 4, 'Di', 'diegosaouda@gmail.com', '123'),
(5, 5, 'Di', 'diegosaouda@gmail.com', '123'),
(6, 6, 'Di', 'diegosaouda@gmail.com', '123'),
(7, 7, 'Di', 'diegosaouda@gmail.com', '123'),
(8, 8, 'Di', 'diegosaouda@gmail.com', '123'),
(9, 9, 'Di', 'diegosaouda@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) unsigned NOT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=10 ;

--
-- Fazendo dump de dados para tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `id_cliente`, `nome`, `telefone`) VALUES
(1, 1, 'Diego Saouda', '(11) 995478336'),
(2, 2, 'Diego Saouda', '(11) 995478336'),
(3, 3, 'Diego Saouda', '(11) 995478336'),
(4, 4, 'Diego Saouda', '(11) 995478336'),
(5, 5, 'Diego Saouda', '(11) 995478336'),
(6, 6, 'Diego Saouda', '(11) 995478336'),
(7, 7, 'Diego Saouda', '(11) 995478336'),
(8, 8, 'Diego Saouda', '(11) 995478336'),
(9, 9, 'Diego Saouda', '(11) 995478336');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
