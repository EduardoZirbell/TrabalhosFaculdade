def cifrar(mensagem, n_col):
    msg = mensagem.replace(" ", "")
    n_lin = -(-len(msg) // n_col)  # ceil sem importar math
    tabela = ['' for _ in range(n_lin * n_col)]
    for i, letra in enumerate(msg):
        tabela[i] = letra
    resultado = ''
    for c in range(n_col):
        for l in range(n_lin):
            pos = l * n_col + c
            if tabela[pos]:
                resultado += tabela[pos]
    return resultado

def decifrar(codigo, n_col):
    n_lin = -(-len(codigo) // n_col)
    tabela = ['' for _ in range(n_lin * n_col)]
    idx = 0
    for c in range(n_col):
        for l in range(n_lin):
            pos = l * n_col + c
            if idx < len(codigo):
                tabela[pos] = codigo[idx]
                idx += 1
    return ''.join([letra for letra in tabela if letra])

def main():
    escolha = input("1 para cifrar, 2 para decifrar: ").strip().upper()
    n_col = int(input("Número de colunas: "))
    if escolha == '1':
        mensagem = input("Mensagem para cifrar: ")
        print("Resultado:", cifrar(mensagem, n_col))
    elif escolha == '2':
        codigo = input("Texto decifrado: ")
        print("Original:", decifrar(codigo, n_col))
    else:
        print("Escolha inválida.")

if __name__ == "__main__":
    main()