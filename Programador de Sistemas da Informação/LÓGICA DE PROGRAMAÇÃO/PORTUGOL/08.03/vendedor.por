programa
{
	
	funcao inicio()
	{
		real sal, ven, fin
		
		cadeia nom

		sal = 0
		ven = 0
		fin = 0
		nom = ""
	
		escreva("Qual seu nome? ")
		leia(nom)
		escreva("\nQual seu salário fixo? ")
		leia(sal)
		escreva("\nQuantas vendas efetuadas no mês? (Em dinheiro) ")
		leia(ven)

		fin = (ven * 0.15) + sal

		escreva("\n\nSeu nome é: " + nom)
		escreva("\nSeu salário fixo é: " + sal)
		escreva("\nSeu total de vendas em dinheiro é de: " + ven)
		escreva("\nSeu salário final é de: " + fin + "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 74; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */