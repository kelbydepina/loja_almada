-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Tempo de geração: 24-Maio-2022 às 01:13
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lojaencomenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaoempresarial`
--

CREATE TABLE `cartaoempresarial` (
  `idcartaoEmpresarial` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `saldo` varchar(45) NOT NULL,
  `dataValidade` varchar(45) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cartaoempresarial`
--

INSERT INTO `cartaoempresarial` (`idcartaoEmpresarial`, `numero`, `saldo`, `dataValidade`, `codigo`, `nome`) VALUES
(1, 12345670, '12360.0', '02-07-2040', 1234, 'Loja-lda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartaoparticular`
--

CREATE TABLE `cartaoparticular` (
  `idcartao` int(11) NOT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `saldo` varchar(45) DEFAULT NULL,
  `dataValidade` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `Cliente_CodigoCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cartaoparticular`
--

INSERT INTO `cartaoparticular` (`idcartao`, `numero`, `saldo`, `dataValidade`, `codigo`, `categoria`, `Cliente_CodigoCliente`) VALUES
(1, '12345678', '200.0', '12-04-2021', '1234', 'Particular', 1),
(2, '12345679', '1500', '10-12-2020', '1234', 'Particular', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `CodigoCliente` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `morada` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`CodigoCliente`, `nome`, `email`, `morada`, `telefone`) VALUES
(1, 'Maria', 'maria@yahoo.com', 'Calheta', '0920233'),
(2, 'Paulo', 'paulo1@hotmail.com', 'Tarrafal', '0238787');

-- --------------------------------------------------------

--
-- Estrutura da tabela `encomenda`
--

CREATE TABLE `encomenda` (
  `codigoEncomenda` varchar(45) NOT NULL,
  `Cliente_CodigoCliente` int(11) NOT NULL,
  `Produto_idProduto` int(11) NOT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `quantidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `encomenda`
--

INSERT INTO `encomenda` (`codigoEncomenda`, `Cliente_CodigoCliente`, `Produto_idProduto`, `valor`, `quantidade`, `estado`) VALUES
('1', 1, 2, '60', '2', 'pendente'),
('2', 1, 3, '10000.0', '2', 'Pago');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `nome`, `preco`) VALUES
(1, 'Pera', '50'),
(2, 'Laranja', '30'),
(3, 'Milho', '5000.0');

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilizador`
--

CREATE TABLE `utilizador` (
  `idUtilizador` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `morada` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `utilizador`
--

INSERT INTO `utilizador` (`idUtilizador`, `username`, `password`, `tipo`, `nome`, `morada`) VALUES
(1, 'ana', '1234', 'vendedor', 'Ana Lopes', 'Praia'),
(2, 'pedro', '1234', 'admin', 'Pedro Mendes', 'Praia'),
(3, 'rita', '123', 'cliente', 'Rita Fereira', 'Praia'),
(4, 'jose', '123', 'gestor', 'Jose Tavares', 'Praia');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cartaoempresarial`
--
ALTER TABLE `cartaoempresarial`
  ADD PRIMARY KEY (`idcartaoEmpresarial`);

--
-- Índices para tabela `cartaoparticular`
--
ALTER TABLE `cartaoparticular`
  ADD PRIMARY KEY (`idcartao`,`Cliente_CodigoCliente`),
  ADD KEY `fk_cartao_Cliente_idx` (`Cliente_CodigoCliente`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CodigoCliente`);

--
-- Índices para tabela `encomenda`
--
ALTER TABLE `encomenda`
  ADD PRIMARY KEY (`codigoEncomenda`,`Cliente_CodigoCliente`,`Produto_idProduto`),
  ADD KEY `fk_Cliente_has_Produto_Produto1_idx` (`Produto_idProduto`),
  ADD KEY `fk_Cliente_has_Produto_Cliente1_idx` (`Cliente_CodigoCliente`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`);

--
-- Índices para tabela `utilizador`
--
ALTER TABLE `utilizador`
  ADD PRIMARY KEY (`idUtilizador`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cartaoempresarial`
--
ALTER TABLE `cartaoempresarial`
  MODIFY `idcartaoEmpresarial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `cartaoparticular`
--
ALTER TABLE `cartaoparticular`
  MODIFY `idcartao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT de tabela `utilizador`
--
ALTER TABLE `utilizador`
  MODIFY `idUtilizador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `cartaoparticular`
--
ALTER TABLE `cartaoparticular`
  ADD CONSTRAINT `fk_cartao_Cliente` FOREIGN KEY (`Cliente_CodigoCliente`) REFERENCES `cliente` (`CodigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `encomenda`
--
ALTER TABLE `encomenda`
  ADD CONSTRAINT `fk_Cliente_has_Produto_Cliente1` FOREIGN KEY (`Cliente_CodigoCliente`) REFERENCES `cliente` (`CodigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_has_Produto_Produto1` FOREIGN KEY (`Produto_idProduto`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
