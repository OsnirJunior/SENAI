programa
{
	
	funcao inicio()
	{
		// definição de variáveis
		real nt1, nt2, nt3, mf
		cadeia status

		// inicialização de variáveis
		//nt1 = 5.5
		//nt2 = 8.5
		//nt3 = 4.7

		escreva("Entre com o valor da 1º nota: \n")
		leia(nt1)
		
		escreva("\nEntre com o valor da 2º nota: \n")
		leia(nt2)
		
		escreva("\nEntre com o valor da 3º nota: \n")
		leia(nt3)
		
		// calcular a média final
		mf = (nt1+nt2+nt3)/3

		se(mf >= 7.0)
		{
			status = "foi APROVADO "
		}
		senao{
			se(mf < 5){
				status = "foi REPROVADO "
			}
			senao{
				status = "precisa de RECUPERAÇÃO "
			}
		}
		
		// falar a média final
		escreva("\nO aluno ", status, "com média final de ", mf)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 137; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */