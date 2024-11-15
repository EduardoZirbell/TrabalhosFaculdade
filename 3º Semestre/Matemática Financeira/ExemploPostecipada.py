import numpy_financial as npf

valorPresente = 4000
i = 0.05
n = 8

pmt = npf.pmt(i, n, valorPresente, when = 'end')
print('- - - - - - - - - - -')
print('O valor das prestações é de $ {:5.2f}'.format(-pmt))
print('- - - - - - - - - - -')

