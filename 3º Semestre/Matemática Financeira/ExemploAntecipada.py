import numpy_financial as npf

valorPresente = 1350
i = 0.07
n = 6

pmt = npf.pmt(i, n, -valorPresente, when = 'begin')
print('- - - - - - - - - - -')
print('O valor das prestações é de $ {:5.2f}'.format(pmt))
print('- - - - - - - - - - -')

