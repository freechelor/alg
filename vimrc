set tabstop=4
set shiftwidth=4
set smartindent
call plug#begin('~/.vim/plugged')
Plug 'junegunn/vim-easy-align'
" Any valid git URL is allowed
Plug 'https://github.com/junegunn/vim-github-dashboard.git'
"
" " Multiple Plug commands can be written in a single line using | separators
Plug 'SirVer/ultisnips' | Plug 'honza/vim-snippets'
"
" " On-demand loading
Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }
Plug 'tpope/vim-fireplace', { 'for': 'clojure' }
"
" " Using a non-master branch
Plug 'rdnetto/YCM-Generator', { 'branch': 'stable' }
"
" " Using a tagged release; wildcard allowed (requires git 1.9.2 or above)
Plug 'fatih/vim-go', { 'tag': '*' }
"
" " Plugin options
Plug 'nsf/gocode', { 'tag': 'v.20150303', 'rtp': 'vim' }
"
" " Plugin outside ~/.vim/plugged with post-update hook
Plug 'junegunn/fzf', { 'dir': '~/.fzf', 'do': './install --all' }
"
" " Unmanaged plugin (manually installed and updated)
Plug '~/my-prototype-plugin'
Plug 'drewtempelmeyer/palenight.vim'
call plug#end()
set background=dark
colorscheme palenight
"let g:lightline.colorscheme = 'palenight'
if (has("nvim"))
	  "For Neovim 0.1.3 and 0.1.4 < https://github.com/neovim/neovim/pull/2198
	  ">
let $NVIM_TUI_ENABLE_TRUE_COLOR=1
endif
	  "
	  "  "For Neovim > 0.1.5 and Vim > patch 7.4.1799 <
	  "  https://github.com/vim/vim/commit/61be73bb0f965a895bfb064ea3e55476ac175162
	  "  >
	  "  "Based on Vim patch 7.4.1770 (`guicolors` option) <
	  "  https://github.com/vim/vim/commit/8a633e3427b47286869aa4b96f2bfc1fe65b25cd
	  "  >
	  "  " < https://github.com/neovim/neovim/wiki/Following-HEAD#20160511 >
if (has("termguicolors"))
	set termguicolors
endif
