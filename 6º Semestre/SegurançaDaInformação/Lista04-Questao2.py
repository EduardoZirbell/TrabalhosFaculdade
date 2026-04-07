def cifrar(mensagem, linhas):
    mensagem = mensagem.replace(" ", "")
    if linhas == 1:
        return mensagem
    grades = ['' for _ in range(linhas)]
    linha = 0
    sentido = 1
    for caractere in mensagem:
        grades[linha] += caractere
        linha += sentido
        if linha == 0 or linha == linhas - 1:
            sentido *= -1
    return ''.join(grades)

def decifrar(codigo, linhas):
    if linhas == 1:
        return codigo
    percurso = []
    linha = 0
    sentido = 1
    for _ in codigo:
        percurso.append(linha)
        linha += sentido
        if linha == 0 or linha == linhas - 1:
            sentido *= -1
    qtd = [percurso.count(i) for i in range(linhas)]

    trilhos = []
    pos = 0
    for quantidade in qtd:
        trilhos.append(list(codigo[pos:pos+quantidade]))
        pos += quantidade
    resultado = []
    trilho_pos = [0] * linhas
    for linha in percurso:
        resultado.append(trilhos[linha][trilho_pos[linha]])
        trilho_pos[linha] += 1
    return ''.join(resultado)

def main():
    escolha = input("Escolha 1 para cifrar ou 2 para decifrar: ").strip().upper()
    linhas = int(input("Digite o número de linhas: "))
    if escolha == '1':
        mensagem = input("Informe a mensagem para cifrar ")
        print("Mensagem cifrada:", cifrar(mensagem, linhas))
    elif escolha == '2':
        codigo = input("Informe o texto decifrado: ")
        print("Mensagem decifrada:", decifrar(codigo, linhas))
    else:
        print("Escolha inválida.")

if __name__ == "__main__":
    main()