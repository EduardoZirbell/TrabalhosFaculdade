% dados(Periodo, Vendedor, Atendimentos, Vendas, AvaliacoesPositivas,
% AvaliacoesNegativas)
dados(1, alberto, 40, 12, 18, 22).
dados(1, bárbara, 25, 25, 24, 1).
dados(1, carol, 48, 30, 25, 23).
dados(1, deivid, 15, 10, 12, 3).
dados(1, ester, 8, 7, 8, 0).

dados(2, alberto, 16, 2, 4, 12).
dados(2, bárbara, 32, 24, 20, 12).
dados(2, carol, 20, 10, 15, 5).
dados(2, deivid, 30, 30, 20, 10).
dados(2, ester, 18, 2, 2, 16).

dados(3, alberto, 10, 3, 5, 5).
dados(3, bárbara, 18, 10, 12, 6).
dados(3, carol, 21, 16, 18, 3).
dados(3, deivid, 25, 19, 18, 7).
dados(3, ester, 20, 12, 10, 10).

%O vendedor(a) que atingirem, simultaneamente, o número de atendimentos igual ao
%número de vendas e 80% (ou mais) de avaliações positivas em algum
%período será bonificado(a).
bonificacao(Periodo, Vendedor) :-
    dados(Periodo, Vendedor, Atendimentos, Vendas, AvaliacoesPositivas, _),
    Vendas == Atendimentos,
    AvaliacoesPositivas >= Atendimentos * 0.8.

%O vendedor(a) que, em algum período, receber 50% (ou mais) de
%avaliações negativas será notificado(a).
notificacao(Periodo, Vendedor) :-
    dados(Periodo, Vendedor, Atendimentos, _, _, AvaliacoesNegativas),
    AvaliacoesNegativas >= Atendimentos * 0.5.

%O vendedor(a) que não realizar nenhuma venda em dois períodos será demitido(a).
demissao(Vendedor) :-
    (naoHouveVendasPeriodo(1, Vendedor),naoHouveVendasPeriodo(2, Vendedor));
    (naoHouveVendasPeriodo(1, Vendedor),naoHouveVendasPeriodo(3, Vendedor));
    (naoHouveVendasPeriodo(2, Vendedor),naoHouveVendasPeriodo(3, Vendedor)).

%Regra Auxiliar para a função de Demissão, retorna True caso houver
%vendas em determinado periodo.
naoHouveVendasPeriodo(Periodo, Vendedor) :-
    dados(Periodo, Vendedor, _, Vendas, _, _),
    Vendas == 0.
