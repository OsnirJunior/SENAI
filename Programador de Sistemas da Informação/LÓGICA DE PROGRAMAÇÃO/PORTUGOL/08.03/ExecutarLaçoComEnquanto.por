programa
{
	
	funcao inicio()
	{
	
		logico controle
		caracter resp
		
		controle = falso

		enquanto(controle == falso){
			
			escreva("Estou executando o laço\n")

			escreva("Deseja continuar executado o laço? (S ou N)\n")
			leia(resp)

			se(resp == 'S'){
				controle = falso
			}
			senao se(resp == 'N'){
				controle = verdadeiro
			}
			senao{
				escreva("Caracter errado\n")
			}
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 125; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */