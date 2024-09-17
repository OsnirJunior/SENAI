programa
{
	
	funcao inicio()
	{
		//Definir variáveis
		inteiro r1, r2, r3, maior
		cadeia status

		// Saída e entrada
		escreva("Qual o valor da primeira reta? ")
		leia(r1)
		escreva("Qual o valor da segunda reta? ")
		leia(r2)
		escreva("Qual o valor da terceira reta? ")
		leia(r3)

		//Verificando se é possível formar um trinângulo
		se(r1 >= r2 e r1 >= r3){
			maior = r1
		}
		senao se(r2 >= r1 e r2 >= r3){
			maior = r2
		}
		senao{
			maior = r3
		}		
		se(maior < (r1 + r2 + r3) - maior){
			se(r1 == r2 e r1 == r3){
			status = ("O formato é de um EQUILÁTERO (Todos os lados iguais)")
			}
			senao se(r1 == r2 ou r1 == r3 ou r2 == r3){
				status = ("O formato é de um ISÓSCELES (Apenas dois lados iguais)") 
			}
			senao{
				status = ("O formato é de um ESCALENO (Todos os lados diferentes)")
			}
		}
		senao{
			status = "É Impossível fazer um triângulo"
		}

		// Saída
		escreva("\n\n" + status + "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 930; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */