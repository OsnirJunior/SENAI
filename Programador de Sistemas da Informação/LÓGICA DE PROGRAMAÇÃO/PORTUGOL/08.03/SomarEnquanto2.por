programa
{
	
	funcao inicio()
	{
		logico continuar = verdadeiro
		inteiro soma = 0
		caracter resp

		escreva("Continuar? (Verdadeiro (1) ou Falso (2))\n")
		leia(resp)
		se(resp == '1') continuar = verdadeiro
		se(resp == '2') continuar = falso
		
		enquanto(continuar){

			soma += 100
			escreva("SOMA = ", soma, "\n")

			escreva("\nContinuar? (Verdadeiro (1) ou Falso (2))\n")
			leia(resp)
			
			se(resp == '1') continuar = verdadeiro
			se(resp == '2') continuar = falso	
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 484; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */