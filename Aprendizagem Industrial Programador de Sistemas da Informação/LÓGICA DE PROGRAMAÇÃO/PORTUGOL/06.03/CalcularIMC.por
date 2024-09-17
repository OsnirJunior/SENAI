programa
{
	
	funcao inicio()
	{
		// definição de variáveis
		cadeia nome
		real peso, altura, imc

		escreva("Qual seu nome? ")
		leia(nome)

		escreva("\nQual sua altura? ")
		leia(altura)

		escreva("\nQual seu peso? ")
		leia(peso)

		imc = peso / (altura*altura)

		escreva("\n")

		escreva(nome, ", seu IMC é: ", imc)

		se(imc >= 40)
		{
			escreva("\n \nVocê está com uma obesidade de grau III.\n")
		}
		
		senao se(imc >= 35)
		{
			escreva("\n \nVocê está com uma obesidade grau II.\n")
		}
		
		senao se(imc >= 30)
		{
				escreva("\n \nVocê está com uma obesidade grau I.\n")
		}
		
		senao se(imc >= 25)
		{
			escreva("\n \nVocê está Acima do peso.\n")
		}

		senao se(imc >= 18.5)
		{
			escreva("\n \nVocê está no peso normal.\n")
		}

		senao se(imc >= 17)
		{
			escreva("\n \nVocê está abaixo do peso.\n")
		}

		senao
		{
			escreva("\nVocê está muito abaixo do peso.\n")
		}
		
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 845; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */