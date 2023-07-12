package loja.mysql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class LojaMysql {
static String estad;
 public static Connection getConexao() throws Exception{
  try{
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/lojaencomenda";
   String username = "root";
   String password = "";
   Class.forName(driver);
   
   Connection conn = DriverManager.getConnection(url,username,password);
 
   return conn;
  } catch(Exception e){System.out.println(e);}
 
 
  return null;
 }
 
 
 public static void inserirProduto(int cod, String n, double pre) throws Exception{
  final int codigoProduto=cod;  
  final String nome=n;
  final double preco=pre;
 try{
     Connection con=getConexao();
     PreparedStatement insProd=con.prepareStatement("INSERT INTO produto(idProduto,nome,preco)values("+codigoProduto+",'"+nome+"','"+preco+"')");
 insProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
System.out.println("=======================================================");
     System.out.println("Novo produto Inserido com Sucesso!");
 }
 
 }
 
 
  public static double precoProduto(int cod) throws Exception{
  final int codigoProduto=cod;  

 try{
     Connection con=getConexao();
     PreparedStatement precProd=con.prepareStatement("SELECT preco FROM produto WHERE idProduto="+codigoProduto+"");
 ResultSet resultado=precProd.executeQuery();
 if(resultado.next())
 {
 double preco=resultado.getDouble("preco");
 return preco;
 }
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
     return 0;
 
 
 }
 
 
    public static int verificaProduto(int cod) throws Exception{
  final int codigoProduto=cod;  
 int cont=0;
 try{
     Connection con=getConexao();
     PreparedStatement precProd=con.prepareStatement("SELECT preco FROM produto WHERE idProduto="+codigoProduto+"");
 ResultSet resultado=precProd.executeQuery();
 if(resultado.next())
 {
cont++;
 }
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
     return cont;
 
 
 }
 
 
 public static void verProduto() throws Exception{
 try{
 Connection con=getConexao();
 PreparedStatement verPr=con.prepareStatement("SELECT * FROM produto");
 ResultSet resultado=verPr.executeQuery();
 System.out.println("******************DADOS DE MYSQL=>PRODUTO****************************");
 while(resultado.next())
 {
     System.out.println("CodigoProduto => "+resultado.getString("idProduto"));
     System.out.println("DesignacaoProduto => "+resultado.getString("nome"));
     System.out.println("PrecoProduto => "+resultado.getString("preco"));
      System.out.println("**************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
 
 }
 
  public static void verUtilizador() throws Exception{
 try{
 Connection con=getConexao();
 PreparedStatement verPr=con.prepareStatement("SELECT * FROM utilizador");
 ResultSet resultado=verPr.executeQuery();
 System.out.println("******************DADOS DE MYSQL=>Utilizador****************************");
 while(resultado.next())
 {
     System.out.println("Username => "+resultado.getString("username"));
     System.out.println("Tipo => "+resultado.getString("tipo"));
     System.out.println("Nome => "+resultado.getString("nome"));
     System.out.println("Morada => "+resultado.getString("morada"));
      System.out.println("**************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
 
 }
 
 
  public static void removProduto(int cod) throws Exception{
  final int codigoProduto=cod;  

 try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("DELETE FROM produto where idProduto="+codigoProduto+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
   System.out.println("=======================================================");
     System.out.println("Produto removido com Sucesso!");
 }
 
 }
 
 
   
  public static void removerUtilizador(int cod) throws Exception{
  final int codigoProduto=cod;  

 try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("DELETE FROM utilizador where idUtilizador="+cod+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
   System.out.println("=======================================================");
     System.out.println("Utilizador removido com Sucesso!");
 }
 
 }
 
 
 
 // CLIENTE
   public static void inserirCliente(int cod, String n,String em ,String m, int tel) throws Exception{
  final int codigoCliente=cod;  
  final String nome=n;
  final String email=em;
  final String morada=m;
  final int telefone=tel;
 try{
     Connection con=getConexao();
     PreparedStatement insClient=con.prepareStatement("INSERT INTO cliente(CodigoCliente,nome,email,morada,telefone)values("+codigoCliente+",'"+nome+"','"+email+"','"+morada+"','"+telefone+"')");
 insClient.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
    System.out.println("=======================================================");
     System.out.println("Novo Cliente Inserido com Sucesso!");
 }
 
 }
   
 // Utilizador
   public static void  adicionarUtilizador(String u,String p ,String t, String n, String m) throws Exception{
   
  final String nome=n;
  final String username = u;
  final String morada=m;
  final String password=p;
  final String tipo=t;
 try{
     Connection con=getConexao();
     PreparedStatement insClient=con.prepareStatement("INSERT INTO utilizador(username,password,tipo,morada)values('"+username+"','"+password+"','"+tipo+"','"+nome+"','"+morada+"')");
 insClient.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
    System.out.println("=======================================================");
     System.out.println("Novo Utilizador Inserido com Sucesso!");
 }
 
 }  
 
 public static void verCliente() throws Exception{
 try{
 Connection con=getConexao();
 PreparedStatement verPr=con.prepareStatement("SELECT * FROM cliente");
 ResultSet resultado=verPr.executeQuery();
 System.out.println("******************DADOS DE MYSQL=>Cliente****************************");
 while(resultado.next())
 {
     System.out.println("CodigoCliente => "+resultado.getString("CodigoCliente"));
     System.out.println("Nome => "+resultado.getString("nome"));
     System.out.println("Email => "+resultado.getString("email"));
          System.out.println("Morada => "+resultado.getString("morada"));
               System.out.println("Telefone => "+resultado.getString("telefone"));
      System.out.println("**************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
 
 }
 
 
  public static void removCliente(int cod) throws Exception{
  final int codigoCliente=cod;  

 try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("DELETE FROM cliente where CodigoCliente="+codigoCliente+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
  System.out.println("=======================================================");
     System.out.println("Cliente removido com Sucesso!");
 }
 
 }
 
 
  //Promocao
 
      public static int verificaPromocao(int cod) throws Exception{
  final int codigoProduto=cod;  
 int cont=0;
 try{
     Connection con=getConexao();
     PreparedStatement precProd=con.prepareStatement("SELECT * FROM promocao WHERE idProduto="+codigoProduto+"");
 ResultSet resultado=precProd.executeQuery();
 if(resultado.next())
 {
cont++;
 }
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }

     return cont;
 
 
 }
 
     
      public static int valorPromocao(int cod) throws Exception{
  final int codigoProduto=cod;  
 int valor=0;
 try{
     Connection con=getConexao();
     PreparedStatement precProd=con.prepareStatement("SELECT desconto FROM promocao WHERE idProduto="+codigoProduto+"");
 ResultSet resultado=precProd.executeQuery();
 if(resultado.next())
 {
valor=resultado.getInt("desconto");

 }
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
   
  return valor;
 
 }      
     
  public static void   verPromocao() throws Exception{
 
 try{
     Connection con=getConexao();
     PreparedStatement listProm=con.prepareStatement("SELECT * FROM promocao");
 ResultSet resultado=listProm.executeQuery();
     System.out.println("****************LISTA DE PROMOCAO DO PRODUTO*******************");
 while(resultado.next())
 {
     System.out.println("CodigoProduto=>"+ resultado.getString(1));
 System.out.println("descontoProduto=>"+ resultado.getString(2)+"%");
     System.out.println("******************************************************************");

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
   
     
 }
  }
 
 public static void adcionaPromocao(int cod, int promo) throws Exception{
 
 
  try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("insert into promocao values("+cod+","+promo+")");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     return;
 }
 finally{
  System.out.println("=======================================================");
     System.out.println("Produto promovido com sucesso!");
 }
 

 
 
 
 }
 
 
  public static void removePromocao(int cod) throws Exception{
 
 
  try{
     Connection con=getConexao();
     PreparedStatement delProm=con.prepareStatement("DELETE FROM promocao where idProduto="+cod+"");
     int a=delProm.executeUpdate();

 if(a==1)
 {
   System.out.println("=======================================================");
     System.out.println("Promocao eliminado com sucesso!");
 }else{
       System.out.println("=======================================================");
      System.out.println("Este Codigo do produto nao exite!");
 }
 
 }catch(Exception e)
 {
     System.out.println("Erro=>"+e);
     return;
 }

   
 }
 
 //Encomenda
 
      public static void filaEnc(String codE){
   
      // Criando uma fila
        Queue<String> fila = new LinkedList<>();
        // Adicionando elementos à fila
        fila.add(codE);
        // Obtendo o tamanho da fila da encomenda
        int tamanho = fila.size();
        System.out.println("Tamanho da fila de encomenda: " + tamanho);

   
        // Verificando se a fila da encomenda está vazia
        boolean vazia = fila.isEmpty();
        System.out.println("Fila de encomenda está vazia? " + vazia);

        // Percorrendo e imprimindo os encomendas restantes na fila
        System.out.println("Encomendas restantes na fila:");
        for (String encomenda : fila) {
            System.out.println(encomenda);
        }
   
   
    }
 
     public static void inserirEncomenda(int codE, int codC,int codP, int quant) throws Exception{
  final int codigoEncomenda=codE;  
  final int codigoCliente=codC;  
  final int codigoProduto=codP;
         int verPro=verificaPromocao(codP);
       
         if(verPro!=0)
         {
             int descont=valorPromocao(codP);
         final double valor=precoProduto(codP);
         double valor1=(valor*descont)/100;
         final double valorTotal=valor1*quant;
       
                 
  final int quantidade=quant;
  final String estado="Pendente";
 
 try{ int cont=0;
     Connection con=getConexao();
     
      PreparedStatement veriEnct=con.prepareStatement("SELECT * from encomenda where codigoEncomenda="+codigoEncomenda+"");
     ResultSet resultado=veriEnct.executeQuery();
     while(resultado.next())
     {
     cont++;
     }
     if(cont!=0){
         System.out.println("****************************************************");
         System.out.println("Já existe encomenda com esse codigo, tente com outra!");
         return;
     
     }else
     {
       System.out.println("=======================================================");
     System.out.println("Novo Encomenda Inserido com Sucesso!");
     
         filaEnc(String.valueOf(codE));
     }
     
     
     PreparedStatement insClient=con.prepareStatement("INSERT INTO Encomenda(CodigoEncomenda,Cliente_CodigoCliente,Produto_idProduto,valor,quantidade,estado)values("+codigoEncomenda+","+codigoCliente+","+codigoProduto+",'"+valorTotal+"','"+quantidade+"','"+estado+"')");
 insClient.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("Falha Cliente deve existe primiero");
     
 }

         
         
         
         }else{
             
         
  final double valor=precoProduto(codP)*quant;
  final int quantidade=quant;
  final String estado="Pendente";
 
 try{ int cont=0;
     Connection con=getConexao();
     
      PreparedStatement veriEnct=con.prepareStatement("SELECT * from encomenda where codigoEncomenda="+codigoEncomenda+"");
     ResultSet resultado=veriEnct.executeQuery();
     while(resultado.next())
     {
     cont++;
     }
     if(cont!=0){
         System.out.println("****************************************************");
         System.out.println("Já existe encomenda com esse codigo, tente com outra!");
         return;
     
     }else
     {
       System.out.println("=======================================================");
     System.out.println("Novo Encomenda Inserido com Sucesso!");
     }
     
     
     PreparedStatement insClient=con.prepareStatement("INSERT INTO Encomenda(CodigoEncomenda,Cliente_CodigoCliente,Produto_idProduto,valor,quantidade,estado)values("+codigoEncomenda+","+codigoCliente+","+codigoProduto+",'"+valor+"','"+quantidade+"','"+estado+"')");
 insClient.executeUpdate();
 }catch(Exception e)
 {
   System.out.println("Falha Cliente deve existe primiero");
     
 }

 
 }
     }
     
     
         
   
     public static void pagaEncomenda(int codE) throws Exception{
  final int codigoEncomenda=codE;  
 

 
 try{ String estad="Pago", getEstado=null;

     Connection con=getConexao();
     PreparedStatement verEst=con.prepareStatement("SELECT estado from encomenda where codigoEncomenda="+codE+"" );
     ResultSet resultado=verEst.executeQuery();
             while(resultado.next()){
     
             getEstado=resultado.getString("estado");
             }

       if(getEstado.equals("Pago")){
        System.out.println("*****************************************************************");
        System.out.println("    Esta encomenda já se encontre pago!");
    return;
    }
     
     
     PreparedStatement insClient=con.prepareStatement("UPDATE Encomenda set estado='"+estad+"' where codigoEncomenda="+codigoEncomenda+"");
 insClient.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }

 
 }
       
     
     
     
     
       public static String estadoEncomenda(int cod) throws IOException, Exception{
  final int codigoEncomenda=cod;  

 String estado=null;
 try{
     Connection con=getConexao();
     PreparedStatement estEnc=con.prepareStatement("SELECT DISTINCT estado FROM encomenda WHERE codigoEncomenda="+codigoEncomenda+"");
 ResultSet resultado=estEnc.executeQuery();

 if(resultado.next())
 {
estado=resultado.getString("estado");


 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     System.out.println("A encomenda com codigo="+codigoEncomenda+"não existe na banco");
     
 }
finally{
 

     return estado;
   
     
 }
 }
       
                  public static int verifyEncomenda(int cod) throws Exception{
   
 int cont=0;
 
 try{
    int codigoEncomenda=cod;
     Connection con=getConexao();
     PreparedStatement estEnc=con.prepareStatement("SELECT * FROM encomenda WHERE codigoEncomenda="+codigoEncomenda+"");
 ResultSet resultado=estEnc.executeQuery();

 if(resultado.next())
 {
cont++;

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

     return cont;
   
     
 }
 }
       
       
       
            public static double totalEncomenda(int cod) throws IOException, Exception{
   
double totalEnc=0;
 
 try{
    int codigoEncomenda=cod;
     Connection con=getConexao();
     PreparedStatement totalEn=con.prepareStatement("SELECT sum(valor) as total FROM encomenda where CodigoEncomenda="+codigoEncomenda+"");
 ResultSet resultado=totalEn.executeQuery();

 if(resultado.next())
 {
totalEnc=resultado.getDouble("total");

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 
   return totalEnc;
   
     
 }
 }
       public static void   criaCartao(int idc,int nu,double sa, String da, int cod, String cat,int codC)throws Exception  {
    try{
       
     Connection con=getConexao();
     PreparedStatement criarC=con.prepareStatement("INSERT INTO cartaoparticular(idcartao,numero,saldo,dataValidade,codigo,categoria,Cliente_CodigoCliente) values("+idc+","+nu+","+sa+",'"+da+"',"+cod+",'"+cat+"',"+codC+")");
 criarC.executeUpdate();


 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

   
     
 }
   
       
       
       
       }
       
       
       
     
   public static void verEncomenda() throws Exception{
 try{
 Connection con=getConexao();
 PreparedStatement verEnc=con.prepareStatement("SELECT * FROM encomenda");
 ResultSet resultado=verEnc.executeQuery();
 System.out.println("******************DADOS DE MYSQL=>ENCOMENDA****************************");
 while(resultado.next())
 {
     System.out.println("CodEncomenda=> "+resultado.getString("CodigoEncomenda"));
     System.out.println("CodigoCliente=> "+resultado.getString("Cliente_CodigoCliente"));
     System.out.println("CodigoProduto => "+resultado.getString("Produto_idProduto"));
     System.out.println("Valor => "+resultado.getString("valor"));
     System.out.println("Quantidade => "+resultado.getString("quantidade"));
     System.out.println("Estado => "+resultado.getString("estado"));
     System.out.println("***************************************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
 
 }
   
     public static void removEncomenda(int cod) throws Exception{
  final int codigoEnc=cod;  

 try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("DELETE FROM encomenda where codigoEncomenda="+codigoEnc+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
  System.out.println("=======================================================");
     System.out.println("Encomenda removido com Sucesso!");
 }
 
 }
 
 //cartao-------------------------------------------------------------------------------
       public static void removCartao(int cod) throws Exception{


 try{
     Connection con=getConexao();
     PreparedStatement delProd=con.prepareStatement("DELETE FROM cartaoparticular where idcartao="+cod+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
   System.out.println("=======================================================");
     System.out.println("Cartao removido com Sucesso!");
 }
 
 }
     
     public static void listaCParticular(){
      try{
 Connection con=getConexao();
 PreparedStatement verEnc=con.prepareStatement("SELECT * FROM cartaoparticular ");
 ResultSet resultado=verEnc.executeQuery();
 System.out.println("******************LISTAR=>dados de bancos Parrticular****************************");
 while(resultado.next())
 {
         
     System.out.println("numero=> "+resultado.getString("numero"));
     System.out.println("Saldo=> "+resultado.getString("saldo"));
     System.out.println("dataValidade => "+resultado.getString("dataValidade"));
     System.out.println("codigo => "+resultado.getString("codigo"));
     System.out.println("Categoria => "+resultado.getString("categoria"));
     System.out.println("CodigoCliente => "+resultado.getString("Cliente_CodigoCliente"));
     System.out.println("***************************************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
     
     
     
     }
     
     
     
     
       
     public static void recarregCart(int num,double valor) throws Exception{
 
 try{ double saldo=0;
 int cont=0;
     Connection con=getConexao();
     
      PreparedStatement verSald=con.prepareStatement("SELECT saldo from cartaoparticular where numero="+num+" ");
 ResultSet resultado=verSald.executeQuery();
 while(resultado.next())
 {cont++;
  saldo=resultado.getDouble("saldo");
 }
     if(cont!=0){
         System.out.println("*******************************************************");
         System.out.println(" SEU SALDO FOI ACTUALIZADO COM SUCESSO");

     }else{
     System.out.println("*******************************************************");
     System.out.println("NUMERO DESCONHECIDO, TENTE NOVAMENTE!");

     }
     
     saldo=saldo+valor;
     
     PreparedStatement delProd=con.prepareStatement("UPDATE cartaoparticular set saldo="+saldo+" where numero="+num+"");
 delProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }

 
 }
 
     
     
     
     
        public static void listaCEmpresarial(){
     
      try{
 Connection con=getConexao();
 PreparedStatement verEnc=con.prepareStatement("SELECT * FROM cartaoempresarial ");
 ResultSet resultado=verEnc.executeQuery();
 System.out.println("******************LISTAR=>dados de Bancos Empresarial**************************");
 while(resultado.next())
 {  
     System.out.println("numero=> "+resultado.getString("numero"));
     System.out.println("Saldo=> "+resultado.getString("saldo"));
     System.out.println("dataValidade => "+resultado.getString("dataValidade"));
     System.out.println("codigo => "+resultado.getString("codigo"));
     System.out.println("NomeEmpresa => "+resultado.getString("nome"));
     
     System.out.println("***************************************************************************");
 }
 }catch (Exception e) {
 
     System.out.println("Erro => "+e);
 }
     
     
     
     
     }
   
     public static void   consultaSaldoParticular(int num, int codig){
         double saldo=0;
 try{
     Connection con=getConexao();
     PreparedStatement conSald=con.prepareStatement("SELECT saldo FROM cartaoparticular where numero="+num+" AND codigo="+codig+"");
 ResultSet resultado=conSald.executeQuery();

while(resultado.next()){
saldo=resultado.getDouble("saldo");
     System.out.println("=======================================================");
 System.out.println("Tu tens "+resultado.getString("saldo")+" na sua conta!");  
 
}
 }catch(Exception e)
 {System.out.println("********************************************************");
     System.out.println("Credencial Invalido"+e);
   
 }
 finally{

    // System.out.println("Esta Loja/Empresa possui "+saldo+" na sua conta!");
 }
 
     
     
     
     }
     
     public static void   consultaSaldoEmpresa(int cod) throws Exception {
     double saldo=0;
 try{
     Connection con=getConexao();
     PreparedStatement conSald=con.prepareStatement("SELECT saldo FROM cartaoempresarial where idcartaoEmpresarial="+cod+"");
 ResultSet resultado=conSald.executeQuery();

while(resultado.next()){
saldo=resultado.getDouble("saldo");
     System.out.println("=======================================================");
 System.out.println("Esta Loja/Empresa possui "+resultado.getString("saldo")+" na sua conta!");  
 
}
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
   
 }
 finally{

    // System.out.println("Esta Loja/Empresa possui "+saldo+" na sua conta!");
 }
 
     
     
     
   
     
     }
     
     
     
     
     
     
  public static int verifyCartao(int cod) throws IOException, Exception{
   
 int cont=0;
 
 try{
    int numeroCartao=cod;
     Connection con=getConexao();
     PreparedStatement cart=con.prepareStatement("SELECT * FROM cartaoparticular WHERE numero="+numeroCartao+"");
 ResultSet resultado=cart.executeQuery();

 if(resultado.next())
 {
cont++;

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

     return cont;
   
     
 }
 }
               
               
        public static void  saldoAumProp(double te) throws Exception{
 double salEmp=saldoEmpresa();
         double lucro=te+salEmp;  
 
 try{
     Connection con=getConexao();
     PreparedStatement insProd=con.prepareStatement("UPDATE  cartaoempresarial set saldo="+lucro+"");
 insProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }

 
 }            
               
       
public static double  saldoEmpresa() throws Exception{
 double lucroT=0;  
 try{
     Connection con=getConexao();
     PreparedStatement saldEm=con.prepareStatement("SELECT saldo FROM  cartaoempresarial");
 ResultSet resultado=saldEm.executeQuery();
 if(resultado.next()){
 lucroT=resultado.getDouble("saldo");
 
 }
     
 
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }
 finally{
 
 
 return lucroT;
 }

 
 }
               
               
               
               
   public static void  saldoDimiClien(int cod,double total) throws Exception{
  final int numeroCartao=cod;  
  double tot=total;
 try{
     Connection con=getConexao();
     PreparedStatement insProd=con.prepareStatement("UPDATE  cartaoparticular set saldo="+tot+" where numero="+cod+"");
 insProd.executeUpdate();
 }catch(Exception e)
 {
     System.out.println("erro => "+e);
     
 }

 
 }
 
         
     
         
         
         
         
         
               
               
               
  public static int verifyNuCartao(int nu,int cod) throws IOException, Exception{
   
 int cont=0;
 
 try{
    int codigoCartao=cod;
    int numeroCartao=nu;
     Connection con=getConexao();
     PreparedStatement cartCod=con.prepareStatement("SELECT * FROM cartaoparticular WHERE codigo="+codigoCartao+" AND numero="+numeroCartao+"");
 ResultSet resultado=cartCod.executeQuery();

 if(resultado.next())
 {
cont++;

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

     return cont;
   
     
 }
 }                
 
 public static void verifySaldoCartao(int num) throws IOException, Exception{
   String saldo=null;

 try{
   int numeroCartao=num;
     Connection con=getConexao();
     PreparedStatement saldcart=con.prepareStatement("SELECT saldo FROM cartaoparticular WHERE numero="+numeroCartao+"");
 ResultSet resultado=saldcart.executeQuery();

 if(resultado.next())
 {
 saldo=resultado.getString("saldo");

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

     System.out.println(saldo);
   
     
 }
 }
 
 
   public static double verifySaldoCartao1(int num) throws IOException, Exception{
   double saldo=0;

 try{
   int numCartao=num;
     Connection con=getConexao();
     PreparedStatement saldcart=con.prepareStatement("SELECT saldo FROM cartaoparticular WHERE numero="+numCartao+"");
 ResultSet resultado=saldcart.executeQuery();

 if(resultado.next())
 {
 saldo=resultado.getDouble("saldo");

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

    return saldo;
   
     
 }
 }
 
 
 
  public static int validar(String user, String pass) throws IOException, Exception{
   int val=0;

 try{

     Connection con=getConexao();
     PreparedStatement saldcart=con.prepareStatement("SELECT tipo FROM utilizador WHERE username='"+user+"' AND password='"+pass+"'");
 ResultSet resultado=saldcart.executeQuery();

 if(resultado.next())
 {
  String tipo=resultado.getString("tipo");
 
     if (tipo.equals("admin")) {
       
         val = 1;
     }
     else if(tipo.equals("gestor")){
          val = 2;
     }
       else if(tipo.equals("vendedor")){
          val = 3;
     }
       else if(tipo.equals("entregador")){
          val = 4;
     }  else{
          val = 5;
     }

     

 }
 }catch(Exception e)
 {System.out.println("erro=>"+e);
     
 }
finally{
 

    return val;
   
     
 }
 }
 
 public static void inicio() throws Exception{
 System.out.println("******************DADOS DE MYSQL=>Pagina Inicial****************************");
 
 String user, pass;
  Scanner s= new Scanner(System.in);  
  System.out.println("Insira o seu username");
  user = s.next();
  System.out.println("Insira o seu password");
  pass = s.next();
 
  int v = validar(user, pass);
 
     if (v!=1 && v!=2 && v!=3 && v!=4) {
         System.out.println("***********************************************************************");
       System.out.println("Utilizador nao existe");  
     }else{
       
         
         if (v==1) {
            menu_Principal();
         }else if(v==2){
              menu_gestor();
         }else if(v==3){
              menu_vendedor();
         }
         else if(v==4){
              menu_entregador();
         }else{
             menu_cliente();
         }
     }
 }
 
 
 
    public static void main(String[] args) throws Exception{
     
        // TODO code application logic here
         
      // menu_Principal();

      inicio();
    }
   
   
   
    //inicio----------------------------
   
     public static void menu_Principal() throws IOException, Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("============================ Menu Principal =================================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Gerir Produtos");
            System.out.println("2 - Gerir Encomendas");
            System.out.println("3 - Gerir Clientes");
            System.out.println("4 - Gerir Cartao");
            System.out.println("5 - Gerir Promocao");
            System.out.println("6 - Gerir Utilizador");
            System.out.println("7- Sair");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        gerirProdutos();
                        break;
                        }
                case 2:{
                        gerirEncomendas();
                        break;
                        }
                case 3:{
               gerirClientes();
                        break;
                        }
                case 4:{
               gerirCartao();
                        break;
                        }
                   case 5:{
               gerirPromocoes();
                        break;
                        }
                    case 6:{
               gerirUtilizador();
                        break;
                        }
                   
                case 7:{
     
                     
                        System.out.println("A sair .......");
                        return;
                       
                       }
                default : {
                          System.out.println("Opção inválida!");    
                }
            }
        }
       
    }
     
         
     public static void menu_gestor() throws IOException, Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("============================ Menu Principal - Gestor =================================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Gerir Produtos");
            System.out.println("2 - Gerir Encomendas");
            System.out.println("3 - Gerir Clientes");
            System.out.println("4 - Gerir Promocao");
            System.out.println("5- Sair");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        gerirProdutos();
                        break;
                        }
                case 2:{
                        gerirEncomendas();
                        break;
                        }
                case 3:{
               gerirClientes();
                        break;
                        }
                case 4:{
                  gerirPromocoes();
                        break;
                        }
         
                case 5:{
     
                     
                        System.out.println("A sair .......");
                        return;
                       
                       }
                default : {
                          System.out.println("Opção inválida!");    
                }
            }
        }
       
    }
     
     
        public static void menu_vendedor() throws IOException, Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("============================ Menu Principal =================================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Gerir Produtos");
            System.out.println("2 - Gerir Encomendas");
            System.out.println("3 - Gerir Clientes");
            System.out.println("4 - Gerir Cartao");        
            System.out.println("5- Sair");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        gerirProdutos();
                        break;
                        }
                case 2:{
                        gerirEncomendas();
                        break;
                        }
                case 3:{
               gerirClientes();
                        break;
                        }
                case 4:{
               gerirCartao();
                        break;
                        }
           
                case 5:{
     
                     
                        System.out.println("A sair .......");
                        return;
                       
                       }
                default : {
                          System.out.println("Opção inválida!");    
                }
            }
        }
       
    }
       
              public static void menu_entregador() throws IOException, Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("============================ Menu Principal =================================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Gerir Encomendas");
            System.out.println("2 - Gerir Clientes");        
            System.out.println("3- Sair");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        gerirEncomendas();
                        break;
                        }
                case 2:{
                        gerirClientes();
                        break;
                        }
                         
                case 3:{
     
                     
                        System.out.println("A sair .......");
                        return;
                       
                       }
                default : {
                          System.out.println("Opção inválida!");    
                }
            }
        }
       
    }
     
             
       public static void menu_cliente() throws IOException, Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("============================ Menu Principal =================================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - ver Produtos");
            System.out.println("2 - ver Encomendas");
            System.out.println("3 - estado Encomendas");
            System.out.println("4- Sair");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        verProduto();
                        break;
                        }
                case 2:{
                        addEncomenda();
                        break;
                        }
                case 3:{
                        System.out.println("Insira o codigo da encomenda");
                        int codE = s.nextInt();
                    estadoEncomenda(codE);
                        break;
                        }
                case 4:{
               gerirCartao();
                        break;
                        }
           
                case 5:{
     
                     
                        System.out.println("A sair .......");
                        return;
                       
                       }
                default : {
                          System.out.println("Opção inválida!");    
                }
            }
        }
       
    }
     
   
       
/*************************Métodos para Gerir Produtos*************************/
    private static void gerirProdutos() throws Exception{
       
      Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=4){
            System.out.println("============================ Gestão de Produtos =============================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Ver Produtos");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Voltar ao Menu Principal");
            op=s.nextInt();
           
            switch(op){
                case 1:{
         verProduto();
                            break;
                        }
                case 2:{
                            adicionarProdutoNaLoja( );
                            break;
                        }
                case 3:{
                            removerProdutoDaLoja( );
                            break;
                        }
                case 4:{
                            break;
                        }
                default : {
                            System.out.println("Opção inválida!");
                         
                }
            }    
        }
    }
   
    public static void adicionarProdutoNaLoja( ) throws Exception{
        Scanner s= new Scanner(System.in);
        Scanner s1= new Scanner(System.in);
        System.out.println("Insere o código do Produto");
        int co=s.nextInt();
        s.reset();
        System.out.println("Insere a designação do Produto");
        String de =s1.nextLine();
        s.reset();
        System.out.println("Insere o preço do Produto");
        double pr =s.nextDouble();
       
        inserirProduto(co,de,pr);
         
    }
   
    public static void removerProdutoDaLoja( ) throws Exception{
       
           Scanner s= new Scanner(System.in);    
           System.out.println("Insere o código do Produto para que seja removido");
           int cod=s.nextInt();
           removProduto(cod);
       
       
    }
       
   
    /********************************************************************************/
   
   
    /*************************Métodos para GERIR ENCOMENDAS*************************/
    private static void gerirEncomendas() throws Exception{
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=6){
            System.out.println("========================== Gestão de Encomendas =============================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Ver Encomendas");
            System.out.println("2 - Adicionar Encomenda");
            System.out.println("3 - Remover Encomenda");
            System.out.println("4 - ver estado da encomenda");
            System.out.println("5 - Efectuar a Pagamento da encomenda");
            System.out.println("6 - Voltar ao Menu Principal");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                        verEncomenda();    
                            break;
                        }
                case 2:{
                           addEncomenda();
                            break;
                        }
                case 3:{
                            System.out.println("Insere o Número da Encomenda");
                            int numero=s.nextInt();
                       removEncomenda(numero);
                            break;
                        }
                case 4:{
                            System.out.println("Insere o Número da Encomenda");
                            int numero=s.nextInt();
                            System.out.println("***********************************************************************");
                       System.out.println("Estado da encomenda do codigo "+numero+" => "+estadoEncomenda(numero));
                         
                            break;
                        }
                case 5:{
               
               comprarProduto();
                break;
                }
                case 6:{
                    try {
                       menu_Principal();  
                    } catch (Exception e) {
                        System.err.println("Houve um erro");
                    }
                   
                break;
                }
         
             
            }    
        }
       
    }
   
   
   
       private static void gerirUtilizador() throws Exception{
       
      Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=4){
            System.out.println("============================ Gestão de Utilizador =============================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Ver utilizador");
            System.out.println("2 - Adicionar utilizador");
            System.out.println("3 - Remover utilizador");
            System.out.println("4 - Voltar ao Menu Principal");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                    verUtilizador();
                            break;
                        }
                case 2:{
                         System.out.println("Insere o username do utilizador");
                            String u=s.next();
                                 System.out.println("Insere o password do utilizador");
                            String p=s.next();
                          System.out.println("Insere o tipo do utilizador");
                            String t=s.next();
                           
                            System.out.println("Insere o nome do utilizador");
                            String n=s.next();
                           
                            System.out.println("Insere a morada do utilizador");
                            String m=s.next();
                            adicionarUtilizador(u,p, t,n ,m);
                            break;
                        }
                case 3:{
                        System.out.println("Insere o id do utilizador");
                            int id=s.nextInt();
                            removerUtilizador(id);
                            break;
                        }
                case 4:{
                            break;
                        }
                default : {
                            System.out.println("Opção inválida!");
                         
                }
            }    
        }
    }
   
    //compra
   
    public static void comprarProduto()throws Exception{
        Scanner s=new Scanner(System.in);
        System.out.println("Insira o codigo da encomenda");
    int codEn=s.nextInt();
        int a=verifyEncomenda(codEn);
        if(a!=0)
        {
       System.out.println("Insira o seu numero do cartão vint24");
       int nu=s.nextInt();
           int b= verifyCartao(nu);
           if(b!=0)
           {
               System.out.println("Insira o seu codigo do cartão vint24");
               int c=s.nextInt();
              int ver= verifyNuCartao(nu,c);
     
               if(ver!=0){
                   double te=totalEncomenda(codEn);
                   double ts=verifySaldoCartao1(nu);
                  double totalPagar=ts-te;
                   if(ts>=te)
                   {
                       saldoDimiClien(nu,totalPagar);
                       saldoAumProp(te);
                       pagaEncomenda(codEn);
                                      System.out.println("***************************************************");
                       System.out.println("Encomenda pago com Sucesso!");
                     
                   }else{
                            System.out.println("***************************************************");
                       System.out.println("Ops Tu tens saldo Insuficiente para esta encomenda!");
                   }
                   
               }else{
                   System.out.println("Desculpa mais o seu codigo esta Errado! Tente novamente");
               }
               
           }else
           {
               System.out.println("Ops esse nunmero não pertence a nenhum cliente!");
           }
           
       
        }else{
            System.out.println("Ops não existe nenhum encomenda com esse codigo!");
        }
     

   
    }
     
   
    //adcionar a encomenda
   
    public static void  addEncomenda() throws Exception{
       
        Scanner s=new Scanner(System.in);
       int codEn, codCli, codP,quant;
       
        System.out.println("Insere o codigo da encomenda");
        codEn=s.nextInt();
        System.out.println("Insere o codigo do Cliente");
        codCli=s.nextInt();
        System.out.println("Insere o codigo da Produto");
        codP=s.nextInt();
        System.out.println("Insere a quantidade pretendida");
        quant=s.nextInt();

     inserirEncomenda(codEn, codCli, codP, quant);
   
   
   
    }
   
   
   
 
   
    public static void gerirCartao() throws Exception{
       
        Scanner s=new Scanner(System.in);
        System.out.println("=================GERIR CARTOES===========================");
        System.out.println("1->Consultar saldo");
        System.out.println("2->Recarregar Cartão");
        System.out.println("3->Listar dados de Cartões Particular");
        System.out.println("4->Listar dados de Cartões Empresarial");
        System.out.println("5->Criar o seu Cartão");
        System.out.println("6->Eliminar o Cartão");
        System.out.println("7->Voltar ao Anterior");
        int op=s.nextInt();
        switch(op){
       
            case 1:
                consultarSaldo();break;
            case 2:
             RecarregarSaldoParticular();break;
            case 3:
               
                   listaCParticular();break;                
            case 4:
                listaCEmpresarial();break;            
            case 5:
              criarContaPart();
                break;
             
            case 6:
        System.out.println("Insira o id do cartao pretendido");
        int id=s.nextInt();
               
                removCartao(id);
                break;
                case 7:
                break;
            default:
            System.err.println("Opcao Invalido");break;
       
        }
               
    }

    public static void criarCartao() throws Exception{
   
        System.out.println("===============CARTAO->CRIAR CONTA=====================");
         Scanner s=new Scanner(System.in);
               
        System.out.println("1->Cartao Empresarial");
        System.out.println("2->Cartao Particular ");
        System.out.println("3->Voltar Anterior");
        int op=s.nextInt();
        switch(op){
            case 1:
                criarContaEmp();break;
            case 2:
                 criarContaPart();break;
            case 3:
                break;
            default:
                System.err.println("Opcao invalida");
       
       
        }
   
    }
    public static void criarContaEmp(){
        System.out.println("===============CRIAR CARTAO EMPRESARIAL==================================");
        Scanner s =new Scanner(System.in);
     
        System.out.println("Insira o numero do cartao pretendido");
        int nu=s.nextInt(),cont=0;

        if(cont!=0)
        {
            System.out.println("==================================================");
            System.out.println("Ops Descuple mas Este numero já Existe!");
        }else{
               System.out.println("Insere o nome da Empresa:");
    String no=s.next();
       
        System.out.println("Insira o codigo do cartao");
        int cod=s.nextInt();
        System.out.println("Insira a data de validade");
         String da=s.next();
        System.out.println("Insira o saldo pretendido");
         int sa=s.nextInt();
        System.out.println("Insira o nome do Banco");
         String ba=s.next();
        System.out.println("Insira o seu o codigo de cliente Associado a este Cartao");
        int codC=s.nextInt();
   
          System.out.println("===================^================================");
            System.out.println("  Obrigado o seu CARTAO EMPRESARIAL foi criado com SUCESSO!");
        }
 
   
    }
    public static void criarContaPart() throws Exception{
        System.out.println("==================CRIAR CARTAO PARTICULAR===============================================");
        Scanner s =new Scanner(System.in);
     
        System.out.println("Insira o numero do cartao pretendido");
        int nu=s.nextInt(),cont=0;
        String cat="Particular";
        cont=verifyCartao(nu);
 
        if(cont!=0)
        {
            System.out.println("==================================================");
            System.out.println("Ops Descuple mas Este numero já Existe!");
        }else{
         
        System.out.println("Insira o idCartao");
        int idc=s.nextInt();
       
        System.out.println("Insira o codigo do cartao");
        int cod=s.nextInt();
        System.out.println("Insira a data de validade");
         String da=s.next();
        System.out.println("Insira o saldo pretendido");
         int sa=s.nextInt();
     
        System.out.println("Insira o seu o codigo de cliente Associado a este Cartao");
        int codC=s.nextInt();
       
    criaCartao(idc,nu,sa,da,cod,cat,codC);
          System.out.println("===================^================================");
            System.out.println("  Obrigado o seu CARTAO PARTICULAR foi criado com SUCESSO!");
        }
 
   

}
      public static void RecarregarSaldoParticular() throws Exception{
  System.out.println("======================CONSULTAR SALDO->Cartao Particular===========================");
          Scanner s=new Scanner(System.in);  
    System.out.println("Insira o seu numero do cartao");
    int n=s.nextInt();
    int cont=0,pass=0;

     System.out.println("Insira o valor da recarga");
    double val=s.nextDouble();
          recarregCart(n,val);
       

   
    }
   

        public static void consultarSaldo()throws Exception
    {   Scanner s=new Scanner(System.in);
               
        System.out.println("======================ESCOLHER TIPO CARTAO============================");
        System.out.println("1->Cartao Empresarial");
        System.out.println("2->Cartao Particular ");
        System.out.println("3->Sair");
        int op=s.nextInt();
     
        switch(op){
            case 1:
                consultaSaldoEmpresa(1);break;
            case 2:
                      System.out.println("Insere o Numero do seu Cartao");
        int nu =s.nextInt();

        System.out.println("Insere o codigo do do seu Cartao");
        int cod =s.nextInt();
     
                consultaSaldoParticular(nu,cod);break;
         
            default:
                System.err.println("Opcao invalida");
               
        }
       


    }      
       
       
       

   
 
   
 
   
 
    /***************************************************************************/
   
    /*******************************Métodos para GERIR CLIENTES*****************/
    private static void gerirClientes() throws Exception{
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=4){
            System.out.println("============================ Gestão de Clientes =============================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Ver Clientes");
            System.out.println("2 - Adicionar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Voltar ao Menu Principal");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                    verCliente();
                        break;
                        }
                case 2:{
                        adicionarClienteNaLoja( );
                        break;
                        }
                case 3:{
                        removerClienteDaLoja( );
                        break;
                        }
                default : {
                          System.out.println("Opção inválida!");
                         
                }
            }    
        }
       
    }

    private static void adicionarClienteNaLoja() throws Exception{
       
        Scanner s= new Scanner(System.in);    
        System.out.println("Insere a morada do nome");
        String no =s.next();
        System.out.println("Insere o código do Cliente");
        int co=s.nextInt();
        System.out.println("Insere a morada do Cliente");
        String mo =s.next();
        System.out.println("Insere o email do Cliente");
        String em =s.next();
        System.out.println("Insere o telefone do Cliente");
        int tl =s.nextInt();
        inserirCliente(co, no, em, em, tl);
    }

    private static void removerClienteDaLoja() throws Exception {
       
        Scanner s= new Scanner(System.in);    
           System.out.println("Insere o código do Cliente para que seja removido");
           int cod=s.nextInt();
           removCliente(cod);
       

    }
   
    /***************************************************************************/
   
    /*******************************Métodos para GERIR PROMOÇÕES*****************/
    private static void gerirPromocoes() throws Exception {
       
        Scanner s= new Scanner(System.in);
        int op =0;
        while(op!=4){
            System.out.println("============================ Gestão de Promocao =============================");
            System.out.println("Escolhe uma opção");
            System.out.println("1 - Ver Promocao");
            System.out.println("2 - Adicionar Promocao");
            System.out.println("3 - Remover Promocao");
            System.out.println("4 - Voltar ao Menu Principal");
            op=s.nextInt();
           
            switch(op){
                case 1:{
                 verPromocao();
                        break;
                        }
                case 2:{
                    System.out.println("Insere o codigo do produto pretendido");
                    int cod=s.nextInt();
                    int verific=verificaProduto(cod);
                    if(verific!=0)
                    {
                        int veriPromo=verificaPromocao(cod);
                        if(veriPromo!=0)
                        {System.out.println("************************************************");
                            System.out.println("Este produto já está na promocao");
                       
                        }else{
                            System.out.println("Insere o valor da promocao");
                    int prom=s.nextInt();
                                 adcionaPromocao(cod, prom);                  
                        }
               
             
                    }
                    else{
                        System.out.println("*****************************************************");
                        System.out.println(" Não existe nenhum produto com esse codigo!");
                    }
                        break;
                        }
                case 3:{
               System.out.println("Insere o codigo do produto");
                    int codP=s.nextInt();
                                 removePromocao(codP);      
                        break;
                        }
                default : {
                          System.out.println("Opção inválida!");
                         
                }
            }    
        }
       
       
       
    }
   
   
   
   
}





