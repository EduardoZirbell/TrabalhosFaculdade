import numpy_financial as npf

valorPresente = 50000
i = 0.08
n = 12
c = 2

valorPresenteAtualizado = round(npf.fv(i, c, 0, -valorPresente),2)
pmt = npf.pmt(i, n, valorPresenteAtualizado, 0, when = 'begin')
print('- - - - - - - - - - -')
print('Valor das prestações é de $ {:5.2f}'.format(-pmt))
print('- - - - - - - - - - -')

