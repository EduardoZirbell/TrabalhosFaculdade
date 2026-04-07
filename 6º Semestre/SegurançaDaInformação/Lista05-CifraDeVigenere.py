def gerar_chave(texto, chave):
    """Repete a chave até ter o mesmo tamanho do texto (sem contar espaços)."""
    chave_expandida = ""
    j = 0
    for i in range(len(texto)):
        if texto[i] == " ":
            chave_expandida += " "
        else:
            chave_expandida += chave[j % len(chave)]
            j += 1
    return chave_expandida


def cifrar(texto, chave):
    resultado = ""
    chave_expandida = gerar_chave(texto, chave)

    for i in range(len(texto)):
        if texto[i] == " ":
            resultado += " "
        else:
            # Fórmula da cifra: (texto + chave) % 26
            letra = (ord(texto[i]) - 65 + (ord(chave_expandida[i]) - 65)) % 26
            resultado += chr(letra + 65)
    return resultado


def decifrar(texto, chave):
    resultado = ""
    chave_expandida = gerar_chave(texto, chave)

    for i in range(len(texto)):
        if texto[i] == " ":
            resultado += " "
        else:
            # Fórmula da decifra: (texto - chave + 26) % 26
            letra = (ord(texto[i]) - 65 - (ord(chave_expandida[i]) - 65) + 26) % 26
            resultado += chr(letra + 65)
    return resultado

print("\n--- Cifra de Vigenere ---")
print("1 - Cifrar texto")
print("2 - Decifrar texto")
print("0 - Sair")
opcao = input("Escolha: ")

if opcao == "1":
    texto = input("Digite o texto (em maiúsculas): ")
    chave = input("Digite a chave (em maiúsculas): ")
    print("Texto Cifrado:", cifrar(texto, chave))
elif opcao == "2":
    texto = input("Digite o texto cifrado (em maiúsculas): ")
    chave = input("Digite a chave (em maiúsculas): ")
    print("Texto Decifrado:", decifrar(texto, chave))
else:
    print("Opção inválida!")
